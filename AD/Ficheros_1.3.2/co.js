import React, { useEffect, useMemo, useRef, useState } from "react";

// Snake NeoGlow — single-file React component (2 jugadores)
// Visuales: neón, degradados, partículas, movimiento suave e HiDPI
// Controles: P1 = WASD, P2 = Flechas, Space/Enter para pausar, pads en pantalla
// Tailwind solo para el UI; el juego se dibuja en <canvas>

function randInt(min, max) {
  return (Math.random() * (max - min + 1) + min) | 0;
}

function clamp(v, lo, hi) {
  return Math.max(lo, Math.min(hi, v));
}

const DIRS_WASD = {
  w: { x: 0, y: -1 }, W: { x: 0, y: -1 },
  s: { x: 0, y: 1 },  S: { x: 0, y: 1 },
  a: { x: -1, y: 0 }, A: { x: -1, y: 0 },
  d: { x: 1, y: 0 },  D: { x: 1, y: 0 },
};
const DIRS_ARROWS = {
  ArrowUp: { x: 0, y: -1 },
  ArrowDown: { x: 0, y: 1 },
  ArrowLeft: { x: -1, y: 0 },
  ArrowRight: { x: 1, y: 0 },
};

// Pequeño sistema de partículas para efectos jugosos
class Particle {
  constructor(x, y, color) {
    this.x = x + (Math.random() - 0.5);
    this.y = y + (Math.random() - 0.5);
    this.vx = (Math.random() - 0.5) * 4;
    this.vy = (Math.random() - 0.5) * 4;
    this.life = 1; // 0..1
    this.color = color;
    this.size = Math.random() * 0.5 + 0.3;
  }
  update(dt) {
    this.x += this.vx * dt * 8;
    this.y += this.vy * dt * 8;
    this.vx *= 0.98;
    this.vy *= 0.98;
    this.life -= dt * 1.5;
    return this.life > 0;
  }
}

export default function SnakeNeoGlow() {
  const canvasRef = useRef(null);
  const overlayRef = useRef(null);
  const [gridW, setGridW] = useState(24);
  const [gridH, setGridH] = useState(18);
  const [speed, setSpeed] = useState(1); // 0..3
  const [running, setRunning] = useState(true);
  const [score, setScore] = useState(0);
  const [high, setHigh] = useState(() => {
    const v = localStorage.getItem("snake_neoglow_high");
    return v ? parseInt(v) : 0;
  });

  // Estado de juego (refs para evitar re-render por frame)
  const snakeRef = useRef([]);       // P1 (WASD)
  const dirRef = useRef({ x: 1, y: 0 });
  const nextDirRef = useRef({ x: 1, y: 0 });

  const snake2Ref = useRef([]);      // P2 (Flechas)
  const dir2Ref = useRef({ x: -1, y: 0 });
  const nextDir2Ref = useRef({ x: -1, y: 0 });

  const appleRef = useRef({ x: 10, y: 8 });
  const timeRef = useRef({ acc: 0, last: 0 });
  const particlesRef = useRef([]);
  const deadRef = useRef(false);
  const dead2Ref = useRef(false);
  const moveIntervalRef = useRef(120); // ms por celda
  const tickRef = useRef(0);

  const [score2, setScore2] = useState(0);
  const [high2, setHigh2] = useState(() => {
    const v = localStorage.getItem("snake_neoglow_high_p2");
    return v ? parseInt(v) : 0;
  });

  // Celdas lógicas (el tamaño real se calcula respecto al contenedor y DPR)
  const { cw, ch } = useMemo(() => {
    return { cw: gridW, ch: gridH };
  }, [gridW, gridH]);

  // Reinicio de partida (dos jugadores)
  const reset = () => {
    const startLen = 4;
    const sx1 = (cw * 0.3) | 0; // izquierda
    const sy1 = (ch / 2) | 0;
    const sx2 = (cw * 0.7) | 0; // derecha
    const sy2 = (ch / 2) | 0;

    snakeRef.current  = Array.from({ length: startLen }, (_, i) => ({ x: sx1 - i, y: sy1, px: sx1 - i, py: sy1 }));
    dirRef.current    = { x: 1,  y: 0 };
    nextDirRef.current= { x: 1,  y: 0 };

    snake2Ref.current = Array.from({ length: startLen }, (_, i) => ({ x: sx2 + i, y: sy2, px: sx2 + i, py: sy2 }));
    dir2Ref.current   = { x: -1, y: 0 };
    nextDir2Ref.current= { x: -1, y: 0 };

    appleRef.current = placeApple([...snakeRef.current, ...snake2Ref.current], cw, ch);
    timeRef.current = { acc: 0, last: performance.now() };
    particlesRef.current = [];
    deadRef.current = false;
    dead2Ref.current = false;
    setScore(0);
    setScore2(0);
    setRunning(true);
  };

  function placeApple(snake, w, h) {
    while (true) {
      const a = { x: randInt(0, w - 1), y: randInt(0, h - 1) };
      if (!snake.some((s) => s.x === a.x && s.y === a.y)) return a;
    }
  }

  // Teclado
  useEffect(() => {
    const onKey = (e) => {
      const key = e.key;
      if (key === " " || key === "Enter") {
        setRunning((r) => !r);
        return;
      }
      if (DIRS_WASD[key]) {
        const nd = DIRS_WASD[key];
        const cur = dirRef.current;
        if (cur.x + nd.x !== 0 || cur.y + nd.y !== 0) nextDirRef.current = nd;
      } else if (DIRS_ARROWS[key]) {
        const nd2 = DIRS_ARROWS[key];
        const cur2 = dir2Ref.current;
        if (cur2.x + nd2.x !== 0 || cur2.y + nd2.y !== 0) nextDir2Ref.current = nd2;
      }
    };
    window.addEventListener("keydown", onKey);
    return () => window.removeEventListener("keydown", onKey);
  }, []);

  // Tacto / swipe (solo P1)
  useEffect(() => {
    const el = overlayRef.current;
    if (!el) return;
    let startX = 0, startY = 0, active = false;
    const start = (e) => {
      active = true;
      const t = e.touches[0];
      startX = t.clientX; startY = t.clientY;
    };
    const move = (e) => {
      if (!active) return;
      const t = e.touches[0];
      const dx = t.clientX - startX;
      const dy = t.clientY - startY;
      if (Math.hypot(dx, dy) > 24) {
        const ax = Math.abs(dx), ay = Math.abs(dy);
        const nd = ax > ay ? { x: Math.sign(dx), y: 0 } : { x: 0, y: Math.sign(dy) };
        const cur = dirRef.current;
        if (cur.x + nd.x !== 0 || cur.y + nd.y !== 0) nextDirRef.current = nd;
        active = false;
      }
    };
    const end = () => (active = false);
    el.addEventListener("touchstart", start, { passive: true });
    el.addEventListener("touchmove", move, { passive: true });
    el.addEventListener("touchend", end, { passive: true });
    return () => {
      el.removeEventListener("touchstart", start);
      el.removeEventListener("touchmove", move);
      el.removeEventListener("touchend", end);
    };
  }, []);

  // Velocidad
  useEffect(() => {
    moveIntervalRef.current = clamp(140 - speed * 35, 60, 200);
  }, [speed]);

  // Reset al cambiar tamaño lógico
  useEffect(() => {
    reset();
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [cw, ch]);

  // Bucle principal
  useEffect(() => {
    const canvas = canvasRef.current;
    const ctx = canvas.getContext("2d");

    let raf;
    const step = (t) => {
      const { last } = timeRef.current;
      let dt = (t - last) / 1000; // segundos
      timeRef.current.last = t;
      if (dt > 0.2) dt = 0.2; // evitar saltos grandes

      // Escalado HiDPI adaptativo
      const parent = canvas.parentElement;
      const dpr = window.devicePixelRatio || 1;
      const pad = 16;
      const maxW = Math.max(320, parent.clientWidth - pad * 2);
      const maxH = Math.max(260, parent.clientHeight - 140);
      const cellSize = Math.floor(Math.min(maxW / cw, maxH / ch));
      const viewW = cellSize * cw;
      const viewH = cellSize * ch;
      if (canvas.width !== viewW * dpr || canvas.height !== viewH * dpr) {
        canvas.width = viewW * dpr;
        canvas.height = viewH * dpr;
        canvas.style.width = viewW + "px";
        canvas.style.height = viewH + "px";
        ctx.setTransform(dpr, 0, 0, dpr, 0, 0);
      }

      // Actualización lógica a intervalo fijo
      if (running && !(deadRef.current && dead2Ref.current)) {
        timeRef.current.acc += dt * 1000;
        const interval = moveIntervalRef.current;
        while (timeRef.current.acc >= interval) {
          timeRef.current.acc -= interval;
          tick();
          tickRef.current++;
        }
      }

      // Render con interpolación
      const alpha = clamp(timeRef.current.acc / moveIntervalRef.current, 0, 1);
      render(ctx, cellSize, alpha);

      raf = requestAnimationFrame(step);
    };
    raf = requestAnimationFrame((t) => {
      timeRef.current.last = t;
      step(t);
    });
    return () => cancelAnimationFrame(raf);
  }, [running]);

  const tick = () => {
    const s1 = snakeRef.current;
    const s2 = snake2Ref.current;

    // aplicar direcciones encoladas
    dirRef.current = nextDirRef.current;
    dir2Ref.current = nextDir2Ref.current;

    const h1 = s1[0];
    const h2 = s2[0];
    const n1 = { x: h1.x + dirRef.current.x, y: h1.y + dirRef.current.y };
    const n2 = { x: h2.x + dir2Ref.current.x, y: h2.y + dir2Ref.current.y };

    // posiciones anteriores para interpolación
    for (let i = s1.length - 1; i >= 0; i--) { s1[i].px = s1[i].x; s1[i].py = s1[i].y; }
    for (let i = s2.length - 1; i >= 0; i--) { s2[i].px = s2[i].x; s2[i].py = s2[i].y; }

    // colisiones con paredes
    const hitWall1 = n1.x < 0 || n1.y < 0 || n1.x >= cw || n1.y >= ch;
    const hitWall2 = n2.x < 0 || n2.y < 0 || n2.x >= cw || n2.y >= ch;

    // colisiones consigo mismo
    const hitSelf1 = s1.some((seg) => seg.x === n1.x && seg.y === n1.y);
    const hitSelf2 = s2.some((seg) => seg.x === n2.x && seg.y === n2.y);

    // colisiones cruzadas
    const hitOther1 = s2.some((seg) => seg.x === n1.x && seg.y === n1.y);
    const hitOther2 = s1.some((seg) => seg.x === n2.x && seg.y === n2.y);

    // choque de cabezas
    const headOn = n1.x === n2.x && n1.y === n2.y;

    if (headOn || hitWall1 || hitSelf1 || hitOther1) {
      if (!deadRef.current) particlesBurst(h1.x + 0.5, h1.y + 0.5, "#00f5d4");
      deadRef.current = true;
    }
    if (headOn || hitWall2 || hitSelf2 || hitOther2) {
      if (!dead2Ref.current) particlesBurst(h2.x + 0.5, h2.y + 0.5, "#ff8cf7");
      dead2Ref.current = true;
    }

    if (deadRef.current && dead2Ref.current) return; // ambos parados

    // mover serpientes vivas
    if (!deadRef.current) s1.unshift({ x: n1.x, y: n1.y, px: h1.x, py: h1.y });
    if (!dead2Ref.current) s2.unshift({ x: n2.x, y: n2.y, px: h2.x, py: h2.y });

    // comprobar manzana
    const a = appleRef.current;
    const ate1 = !deadRef.current && n1.x === a.x && n1.y === a.y;
    const ate2 = !dead2Ref.current && n2.x === a.x && n2.y === a.y;

    if (ate1) {
      setScore((s) => {
        const n = s + 1; if (n > high) { setHigh(n); localStorage.setItem("snake_neoglow_high", String(n)); } return n;
      });
      particlesBurst(n1.x + 0.5, n1.y + 0.5, "#00f5d4");
    } else if (!deadRef.current) {
      s1.pop();
    }

    if (ate2) {
      setScore2((s) => {
        const n = s + 1; if (n > high2) { setHigh2(n); localStorage.setItem("snake_neoglow_high_p2", String(n)); } return n;
      });
      particlesBurst(n2.x + 0.5, n2.y + 0.5, "#ff8cf7");
    } else if (!dead2Ref.current) {
      s2.pop();
    }

    // nueva manzana si alguien comió
    if (ate1 || ate2) {
      appleRef.current = placeApple([...s1, ...s2], cw, ch);
    }
  };

  const particlesBurst = (x, y, color) => {
    for (let i = 0; i < 24; i++) particlesRef.current.push(new Particle(x, y, color));
  };

  const render = (ctx, cell, alpha) => {
    const w = ctx.canvas.width / (window.devicePixelRatio || 1);
    const h = ctx.canvas.height / (window.devicePixelRatio || 1);

    // Fondo con viñeta
    const grd = ctx.createLinearGradient(0, 0, w, h);
    grd.addColorStop(0, "#0a0f1f");
    grd.addColorStop(1, "#0e1326");
    ctx.fillStyle = grd;
    ctx.fillRect(0, 0, w, h);

    // rejilla neón
    ctx.save();
    ctx.globalAlpha = 0.25;
    ctx.strokeStyle = "#1b2b4b";
    ctx.lineWidth = 1;
    for (let x = 0; x <= cw; x++) {
      const px = x * cell + 0.5;
      ctx.beginPath(); ctx.moveTo(px, 0); ctx.lineTo(px, ch * cell); ctx.stroke();
    }
    for (let y = 0; y <= ch; y++) {
      const py = y * cell + 0.5;
      ctx.beginPath(); ctx.moveTo(0, py); ctx.lineTo(cw * cell, py); ctx.stroke();
    }
    ctx.restore();

    // manzana
    const a = appleRef.current;
    drawApple(ctx, a.x, a.y, cell);

    // serpientes con interpolación
    const s1 = snakeRef.current;
    for (let i = s1.length - 1; i >= 0; i--) {
      const s = s1[i];
      const ix = s.px + (s.x - s.px) * alpha;
      const iy = s.py + (s.y - s.py) * alpha;
      drawSegment(ctx, ix, iy, cell, i === 0, i, true);
    }
    const s2 = snake2Ref.current;
    for (let i = s2.length - 1; i >= 0; i--) {
      const s = s2[i];
      const ix = s.px + (s.x - s.px) * alpha;
      const iy = s.py + (s.y - s.py) * alpha;
      drawSegment(ctx, ix, iy, cell, i === 0, i, false);
    }

    // partículas
    ctx.save();
    for (let i = particlesRef.current.length - 1; i >= 0; i--) {
      const p = particlesRef.current[i];
      if (!p.update(1 / 60)) { particlesRef.current.splice(i, 1); continue; }
      const x = p.x * cell; const y = p.y * cell;
      ctx.globalAlpha = p.life; ctx.shadowBlur = 12; ctx.shadowColor = p.color; ctx.fillStyle = p.color;
      ctx.beginPath(); ctx.arc(x, y, p.size * cell * 0.5, 0, Math.PI * 2); ctx.fill();
    }
    ctx.restore();

    // overlay de muerte
    if (deadRef.current || dead2Ref.current) {
      ctx.save();
      ctx.fillStyle = "rgba(255,0,80,0.08)";
      ctx.fillRect(0, 0, w, h);
      ctx.restore();
    }
  };

  const drawSegment = (ctx, gx, gy, cell, isHead, idx, isP1) => {
    const x = gx * cell;
    const y = gy * cell;
    const r = Math.max(4, cell * 0.22);
    const glow = isHead ? 24 : 12;

    // paletas por jugador
    const grad = ctx.createLinearGradient(x, y, x + cell, y + cell);
    if (isP1) {
      grad.addColorStop(0, isHead ? "#00e5ff" : "#00ffa3");
      grad.addColorStop(1, isHead ? "#00ffa3" : "#00e5ff");
    } else {
      grad.addColorStop(0, isHead ? "#ff8cf7" : "#ffa94d");
      grad.addColorStop(1, isHead ? "#ffa94d" : "#ff8cf7");
    }

    ctx.save();
    ctx.shadowBlur = glow;
    ctx.shadowColor = isP1 ? (isHead ? "#00f5d4" : "#60efff") : (isHead ? "#ff9efc" : "#ffd1a3");
    ctx.fillStyle = grad;
    roundRect(ctx, x + 2, y + 2, cell - 4, cell - 4, r);
    ctx.fill();

    // brillo interno
    ctx.shadowBlur = 0;
    ctx.globalAlpha = 0.25;
    ctx.fillStyle = "#ffffff";
    roundRect(ctx, x + 4, y + 4, cell - 8, cell - 10, r * 0.6);
    ctx.fill();

    // ojos
    if (isHead) {
      ctx.globalAlpha = 1;
      const eye = Math.max(2, cell * 0.12);
      ctx.fillStyle = "#0f172a";
      ctx.beginPath();
      ctx.arc(x + cell * 0.35, y + cell * 0.35, eye, 0, Math.PI * 2);
      ctx.arc(x + cell * 0.65, y + cell * 0.35, eye, 0, Math.PI * 2);
      ctx.fill();
    }
    ctx.restore();
  };

  const drawApple = (ctx, ax, ay, cell) => {
    const x = ax * cell + cell / 2;
    const y = ay * cell + cell / 2;

    ctx.save();
    // cuerpo
    const radius = cell * 0.35;
    const g = ctx.createRadialGradient(x - radius * 0.4, y - radius * 0.4, radius * 0.2, x, y, radius);
    g.addColorStop(0, "#ff9a9e");
    g.addColorStop(1, "#ff2d55");
    ctx.shadowBlur = 18;
    ctx.shadowColor = "#ff2d55";
    ctx.fillStyle = g;
    ctx.beginPath();
    ctx.arc(x, y, radius, 0, Math.PI * 2);
    ctx.fill();

    // brillo
    ctx.shadowBlur = 0;
    ctx.globalAlpha = 0.7;
    ctx.fillStyle = "#fff";
    ctx.beginPath();
    ctx.ellipse(x - radius * 0.3, y - radius * 0.35, radius * 0.15, radius * 0.25, -0.5, 0, Math.PI * 2);
    ctx.fill();

    // hoja
    ctx.globalAlpha = 1;
    ctx.fillStyle = "#2bd9a8";
    ctx.beginPath();
    ctx.ellipse(x + radius * 0.2, y - radius * 0.9, radius * 0.18, radius * 0.28, 0.7, 0, Math.PI * 2);
    ctx.fill();

    ctx.restore();
  };

  const roundRect = (ctx, x, y, w, h, r) => {
    const rr = Math.min(r, w / 2, h / 2);
    ctx.beginPath();
    ctx.moveTo(x + rr, y);
    ctx.arcTo(x + w, y, x + w, y + h, rr);
    ctx.arcTo(x + w, y + h, x, y + h, rr);
    ctx.arcTo(x, y + h, x, y, rr);
    ctx.arcTo(x, y, x + w, y, rr);
    ctx.closePath();
  };

  // UI helpers
  const changeGrid = (delta) => {
    const w = clamp(gridW + delta, 16, 40);
    setGridW(w);
    setGridH(clamp(Math.round((w * 3) / 4), 12, 30)); // relación 4:3
  };

  // Persistencia de récords
  useEffect(() => { localStorage.setItem("snake_neoglow_high", String(high)); }, [high]);
  useEffect(() => { localStorage.setItem("snake_neoglow_high_p2", String(high2)); }, [high2]);

  // "Tests" de ejecución (invariantes sencillos)
  useEffect(() => {
    console.assert(Array.isArray(snakeRef.current), "Snake P1 no es array");
    console.assert(Array.isArray(snake2Ref.current), "Snake P2 no es array");
  }, []);

  return (
    <div className="relative min-h-[80vh] w-full flex flex-col items-center justify-center bg-[radial-gradient(90%_120%_at_0%_0%,#00131f_0%,#000814_50%,#00040a_100%)] text-slate-200">
      <div className="absolute inset-0 pointer-events-none opacity-60" aria-hidden>
        {/* glows */}
        <div className="absolute -top-24 -left-24 h-64 w-64 rounded-full blur-3xl bg-cyan-500/20" />
        <div className="absolute -bottom-24 -right-24 h-72 w-72 rounded-full blur-3xl bg-emerald-500/10" />
      </div>

      <div className="flex items-center gap-4 mb-4">
        <h1 className="text-2xl md:text-3xl font-semibold tracking-tight bg-clip-text text-transparent bg-gradient-to-r from-cyan-300 to-emerald-300 drop-shadow">Snake NeoGlow</h1>
        <span className="px-3 py-1 rounded-full text-sm bg-white/5 border border-white/10">FPS 60</span>
      </div>

      <div ref={overlayRef} className="relative animate-[none]">
        <canvas ref={canvasRef} className="rounded-2xl shadow-[0_0_40px_rgba(0,255,200,0.15)] border border-cyan-400/20 bg-black/20" />
        {/* HUD */}
        <div className="absolute -top-12 left-1/2 -translate-x-1/2 flex items-center gap-3 text-sm">
          <div className="px-3 py-1 rounded-full bg-white/5 border border-white/10">P1 (WASD): <b>{score}</b> {deadRef.current && <span className="ml-2 text-rose-300">✖</span>}</div>
          <div className="px-3 py-1 rounded-full bg-white/5 border border-white/10">P2 (Flechas): <b>{score2}</b> {dead2Ref.current && <span className="ml-2 text-rose-300">✖</span>}</div>
          <div className="hidden md:block px-3 py-1 rounded-full bg-white/5 border border-white/10">Récord P1: <b>{high}</b> · Récord P2: <b>{high2}</b></div>
        </div>

        {/* Pads en pantalla */}
        <div className="absolute -bottom-24 left-1/2 -translate-x-1/2 select-none hidden sm:flex gap-8 opacity-80">
          <div className="flex items-center gap-3">
            <button onClick={() => (nextDirRef.current = { x: 0, y: -1 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">W</button>
            <div className="flex gap-3">
              <button onClick={() => (nextDirRef.current = { x: -1, y: 0 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">A</button>
              <button onClick={() => (nextDirRef.current = { x: 1, y: 0 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">D</button>
            </div>
            <button onClick={() => (nextDirRef.current = { x: 0, y: 1 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">S</button>
          </div>
          <div className="flex items-center gap-3">
            <button onClick={() => (nextDir2Ref.current = { x: 0, y: -1 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">▲</button>
            <div className="flex gap-3">
              <button onClick={() => (nextDir2Ref.current = { x: -1, y: 0 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">◀</button>
              <button onClick={() => (nextDir2Ref.current = { x: 1, y: 0 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">▶</button>
            </div>
            <button onClick={() => (nextDir2Ref.current = { x: 0, y: 1 })} className="px-3 py-2 rounded-xl bg-white/5 border border-white/10 hover:bg-white/10">▼</button>
          </div>
        </div>
      </div>

      {/* Controles */}
      <div className="mt-8 flex flex-wrap items-center justify-center gap-3">
        <button onClick={() => setRunning((r) => !r)} className="px-4 py-2 rounded-2xl bg-cyan-500/20 border border-cyan-400/30 hover:bg-cyan-500/30 shadow-[0_0_20px_rgba(34,211,238,0.2)]">
          {running && !(deadRef.current && dead2Ref.current) ? "Pausa (Space/Enter)" : "Reanudar"}
        </button>
        <button onClick={reset} className="px-4 py-2 rounded-2xl bg-emerald-500/20 border border-emerald-400/30 hover:bg-emerald-500/30">Reiniciar</button>
        <div className="flex items-center gap-2 px-3 py-2 rounded-2xl bg-white/5 border border-white/10">
          <span className="text-sm">Velocidad</span>
          <input type="range" min={0} max={3} step={1} value={speed} onChange={(e) => setSpeed(parseInt(e.target.value))} />
        </div>
        <div className="flex items-center gap-2 px-3 py-2 rounded-2xl bg-white/5 border border-white/10">
          <span className="text-sm">Grid</span>
          <button onClick={() => changeGrid(-2)} className="px-2 py-1 rounded-lg bg-white/10">-</button>
          <span className="tabular-nums">{cw}×{ch}</span>
          <button onClick={() => changeGrid(2)} className="px-2 py-1 rounded-lg bg-white/10">+</button>
        </div>
      </div>

      <p className="mt-6 text-xs text-slate-400/80">Controles: P1 = WASD · P2 = Flechas. Space/Enter para pausar. En móvil, usa los pads o gestos.</p>

      {/* keyframes */}
      <style>{`
        @keyframes shake {
          10%, 90% { transform: translateX(-1px); }
          20%, 80% { transform: translateX(2px); }
          30%, 50%, 70% { transform: translateX(-4px); }
          40%, 60% { transform: translateX(4px); }
        }
      `}</style>
    </div>
  );
}
