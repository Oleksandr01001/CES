from datetime import datetime, timedelta, date

ESTADOS = ["disponible","reservado","mantenimiento"]
DISTRITOS = ["Norte","Sur","Este","Oeste"]
CUPO_MAX = 5

actividades = {
    "Norte":["Natacion","Baloncesto","Tenis","Padel","Fitness","Voleibol"],
    "Sur":["Natacion","Baloncesto","Tenis","Padel","Fitness","Boxeo"],
    "Este":["Natacion","Baloncesto","Tenis","Padel","Fitness","Crossfit"],
    "Oeste":["Natacion","Baloncesto","Tenis","Padel","Fitness","Pilates"],
}

materiales = {}
usuarios = {}
censo = {}
reservas = {}
contexto = {"ubicacion":{"tipo":"almacen","distrito":None,"actividad":None},"usuario":None}
mid_seq = 1
uid_seq = 1001

def hoy():
    return datetime.now().date()

def parse_fecha(s):
    try:
        return datetime.strptime(s.strip(),"%Y-%m-%d").date()
    except:
        return None

def nxt_mid():
    global mid_seq
    mid = mid_seq
    mid_seq += 1
    return mid

def nxt_uid():
    global uid_seq
    uid = uid_seq
    uid_seq += 1
    return uid

def h(pw):
    return str(abs(hash("x"+pw+"x")))

def nv(msg):
    while True:
        s = input(msg).strip()
        if s: return s
        print("entrada vacia")

def opcion(msg, vals):
    low = [v.lower() for v in vals]
    while True:
        s = input(msg).strip()
        if s.lower() in low:
            return vals[low.index(s.lower())]
        print("opcion invalida")

def norm(s):
    return s.strip().lower() if isinstance(s,str) else ""

def nuevo_material(nombre, marca, fecha, estado, origen, ubic):
    mid = nxt_mid()
    materiales[mid] = {"id":mid,"nombre":nombre,"marca":marca,"fecha_alta":fecha,"estado":estado,"origen":origen,"ubicacion":dict(ubic)}

def seed():
    f0 = hoy() - timedelta(days=60)
    marcas = ["ProSport","AquaMax","CourtX","PowerFit","UrbanGym"]
    base = ["Pelota basket","Pelota tenis","Raqueta tenis","Pala padel","Gafas natacion","Aletas","Mancuernas 5kg","Esterilla","Balon 3kg","Comba","Casco boxeo","Guantes boxeo","Conos","Chaleco lastre","Bandas"]
    for i,n in enumerate(base):
        nuevo_material(n,marcas[i%len(marcas)],f0+timedelta(days=i),"disponible",None,{"tipo":"almacen","distrito":None,"actividad":None})
    for d in DISTRITOS:
        propios = [("Kit piscina","AquaMax"),("Carro pelotas","ProSport"),("Red tenis","CourtX"),("Red padel","CourtX"),("Banco press","PowerFit"),
                   ("Cinta correr","UrbanGym"),("Eliptica","UrbanGym"),("Colchoneta","ProSport"),("Balon pro","ProSport"),("Jabalina","ProSport")]
        for i,(n,m) in enumerate(propios):
            nuevo_material(n,m,f0+timedelta(days=10+i),"disponible",d,{"tipo":"centro","distrito":d,"actividad":None})
        otros = [x for x in DISTRITOS if x!=d]
        prest = [("Vallas","ProSport"),("Porteria sala","ProSport"),("Cronometro","UrbanGym"),("Balon 5kg","PowerFit"),("Saco boxeo","PowerFit")]
        for i,(n,m) in enumerate(prest):
            nuevo_material(n,m,f0+timedelta(days=30+i),"disponible",otros[i%3],{"tipo":"centro","distrito":d,"actividad":None})
        por_act = {
            "Natacion":[("Tabla nado","AquaMax"),("Pull buoy","AquaMax"),("Gorro","AquaMax")],
            "Baloncesto":[("Balon t7","ProSport"),("Aros","ProSport"),("Petos","ProSport")],
            "Tenis":[("Raqueta inter","CourtX"),("Bote pelotas","CourtX"),("Red portatil","CourtX")],
            "Padel":[("Pala carbono","CourtX"),("Pelotas padel","CourtX"),("Overgrip","CourtX")],
            "Fitness":[("Kettlebell 8","PowerFit"),("Rueda ab","PowerFit"),("TRX","PowerFit")],
            "Voleibol":[("Balon volley","ProSport"),("Red volley","ProSport"),("Antenas","ProSport")],
            "Boxeo":[("Guantes 12oz","PowerFit"),("Bucal","PowerFit"),("Vendas","PowerFit")],
            "Crossfit":[("Cuerda batida","PowerFit"),("Bumper","PowerFit"),("Caja plio","PowerFit")],
            "Pilates":[("Anillo","UrbanGym"),("Fitball","UrbanGym"),("Ladrillo","UrbanGym")],
        }
        for act in actividades[d]:
            lista = por_act.get(act,[("Gen A","ProSport"),("Gen B","PowerFit"),("Gen C","UrbanGym")])
            for j,(n,m) in enumerate(lista[:3]):
                nuevo_material(n,m,f0+timedelta(days=50+j),"disponible",d,{"tipo":"actividad","distrito":d,"actividad":act})

def mats_en_ubic(ubic):
    r = []
    for m in materiales.values():
        u = m["ubicacion"]
        if ubic["tipo"]=="almacen" and u["tipo"]=="almacen": r.append(m)
        elif ubic["tipo"]=="centro" and u["tipo"]=="centro" and u["distrito"]==ubic["distrito"]: r.append(m)
        elif ubic["tipo"]=="actividad" and u["tipo"]=="actividad" and u["distrito"]==ubic["distrito"] and u["actividad"]==ubic["actividad"]: r.append(m)
    return r

def mats_de_distrito(d):
    r=[]
    for m in materiales.values():
        u=m["ubicacion"]
        if (u["tipo"]=="centro" and u["distrito"]==d) or (u["tipo"]=="actividad" and u["distrito"]==d):
            r.append(m)
    return r

def print_mats(mats,titulo):
    print("\n"+titulo)
    if not mats:
        print("sin materiales")
        return
    print(f"{'ID':>4} | {'Nombre':20} | {'Marca':10} | {'Fecha':10} | {'Estado':11} | {'Ubicacion':22} | {'Origen':6}")
    for m in sorted(mats,key=lambda x:x['id']):
        u=m["ubicacion"]
        loc = "Almacen" if u["tipo"]=="almacen" else (f"Centro {u['distrito']}" if u["tipo"]=="centro" else f"{u['actividad']} ({u['distrito']})")
        print(f"{m['id']:>4} | {m['nombre'][:20]:20} | {m['marca'][:10]:10} | {m['fecha_alta']:%Y-%m-%d} | {m['estado'][:11]:11} | {loc[:22]:22} | {(m['origen'] or '-')[:6]:6}")

def buscar(nombre="",marca="",fecha="",estado="",dentro=None):
    nombre,marca,estado = norm(nombre),norm(marca),norm(estado)
    f = parse_fecha(fecha) if fecha else None
    out=[]
    for m in materiales.values():
        if dentro:
            u=m["ubicacion"]
            if dentro["tipo"]=="almacen" and u["tipo"]!="almacen": continue
            if dentro["tipo"]=="centro" and not (u["tipo"] in ["centro","actividad"] and u["distrito"]==dentro["distrito"]): continue
            if dentro["tipo"]=="actividad" and not (u["tipo"]=="actividad" and u["distrito"]==dentro["distrito"] and u["actividad"]==dentro["actividad"]): continue
        if nombre and nombre not in norm(m["nombre"]): continue
        if marca and marca not in norm(m["marca"]): continue
        if estado and estado!=norm(m["estado"]): continue
        if f and f!=m["fecha_alta"]: continue
        out.append(m)
    return out

def alta_usuario():
    print("\nalta usuario")
    nombre = nv("nombre: ")
    distrito = opcion(f"distrito {DISTRITOS}: ",DISTRITOS)
    actividad = opcion(f"actividad {actividades[distrito]}: ",actividades[distrito])
    pw = nv("contrasena: ")
    clave=(distrito,actividad)
    if len(censo.get(clave,[]))>=CUPO_MAX:
        print("cupo lleno")
        return
    uid = nxt_uid()
    usuarios[uid] = {"id":uid,"nombre":nombre,"distrito":distrito,"actividad":actividad,"pass":h(pw)}
    censo.setdefault(clave,[]).append(uid)
    print(f"usuario creado id {uid}")

def baja_usuario():
    print("\nbaja usuario")
    s = nv("id: ")
    if not s.isdigit(): print("id invalido"); return
    uid=int(s)
    u=usuarios.get(uid)
    if not u: print("no existe"); return
    pw = nv("contrasena: ")
    if u["pass"]!=h(pw): print("contrasena incorrecta"); return
    for mid,r in list(reservas.items()):
        if r["user_id"]==uid:
            materiales[mid]["estado"]="disponible"
            del reservas[mid]
    clave=(u["distrito"],u["actividad"])
    if uid in censo.get(clave,[]): censo[clave].remove(uid)
    del usuarios[uid]
    if contexto["usuario"]==uid: contexto["usuario"]=None
    print("baja ok")

def acceder_almacen():
    contexto["ubicacion"]={"tipo":"almacen","distrito":None,"actividad":None}
    print_mats(mats_en_ubic(contexto["ubicacion"]),"almacen central")

def acceder_centro():
    d = opcion(f"distrito {DISTRITOS}: ",DISTRITOS)
    contexto["ubicacion"]={"tipo":"centro","distrito":d,"actividad":None}
    mats = mats_en_ubic(contexto["ubicacion"])
    print_mats(mats,f"centro {d}")
    s = input("ver prestados s n: ").strip().lower()
    if s=="s":
        otros = [m for m in mats if m["origen"] and m["origen"]!=d]
        print_mats(otros,f"prestados en {d}")

def acceder_actividad():
    print("\nlogin actividad")
    s = nv("id: ")
    if not s.isdigit(): print("id invalido"); return
    uid=int(s)
    u=usuarios.get(uid)
    if not u: print("no existe"); return
    pw = nv("contrasena: ")
    if u["pass"]!=h(pw): print("credenciales invalidas"); return
    contexto["usuario"]=uid
    contexto["ubicacion"]={"tipo":"actividad","distrito":u["distrito"],"actividad":u["actividad"]}
    print(f"acceso ok a {u['actividad']} {u['distrito']}")

def listar_ubicacion():
    ubic=contexto["ubicacion"]
    if ubic["tipo"]=="almacen":
        print_mats(mats_en_ubic(ubic),"almacen central")
    elif ubic["tipo"]=="centro":
        print_mats(mats_en_ubic(ubic),f"centro {ubic['distrito']}")
    else:
        uid=contexto["usuario"]
        if not uid: print("debes autenticarte"); return
        u=usuarios[uid]
        modo=input("1 solo mi actividad 2 todo distrito: ").strip()
        if modo=="2":
            print_mats(mats_de_distrito(u["distrito"]),f"distrito {u['distrito']}")
        else:
            print_mats(mats_en_ubic({"tipo":"actividad","distrito":u["distrito"],"actividad":u["actividad"]}),
                       f"mi actividad {u['actividad']} {u['distrito']}")

def buscar_material():
    print("\nbuscar")
    nombre=input("nombre contiene: ")
    marca=input("marca contiene: ")
    fecha=input("fecha yyyy-mm-dd: ")
    estado=input(f"estado {ESTADOS} vacio opcional: ")
    if estado and norm(estado) not in [e for e in ESTADOS]: estado=""
    res = buscar(nombre,marca,fecha,estado,None)
    print_mats(res,"resultados")

def reservar():
    uid=contexto["usuario"]
    if not uid: print("debes autenticarte"); return
    u=usuarios[uid]
    if sum(1 for r in reservas.values() if r["user_id"]==uid)>=3:
        print("limite 3 reservas"); return
    s=nv("id material: ")
    if not s.isdigit(): print("id invalido"); return
    mid=int(s)
    m=materiales.get(mid)
    if not m: print("no existe"); return
    if m["ubicacion"]["tipo"]=="almacen": print("no se reserva del almacen"); return
    if m["ubicacion"]["distrito"]!=u["distrito"]: print("solo tu distrito"); return
    if m["estado"]!="disponible": print("no disponible"); return
    f=hoy()
    reservas[mid]={"user_id":uid,"fecha_reserva":f,"fecha_limite":f+timedelta(days=4)}
    m["estado"]="reservado"
    print(f"reservado hasta {reservas[mid]['fecha_limite']:%Y-%m-%d}")

def ver_reservas():
    uid=contexto["usuario"]
    if not uid: print("debes autenticarte"); return
    pares=[(mid,r) for mid,r in reservas.items() if r["user_id"]==uid]
    if not pares: print("\nsin reservas"); return
    print("\nmis reservas")
    print(f"{'MatID':>6} | {'Nombre':20} | {'Ubic':22} | {'Desde':10} | {'Limite':10} | {'Estado'}")
    for mid,r in sorted(pares,key=lambda x:x[0]):
        m=materiales[mid]
        u=m["ubicacion"]
        loc = "Almacen" if u["tipo"]=="almacen" else (f"Centro {u['distrito']}" if u["tipo"]=="centro" else f"{u['actividad']} ({u['distrito']})")
        retraso = "atrasado" if hoy()>r["fecha_limite"] else ""
        print(f"{mid:>6} | {m['nombre'][:20]:20} | {loc[:22]:22} | {r['fecha_reserva']:%Y-%m-%d} | {r['fecha_limite']:%Y-%m-%d} | {retraso}")

def devolver():
    uid=contexto["usuario"]
    if not uid: print("debes autenticarte"); return
    s=nv("id material: ")
    if not s.isdigit(): print("id invalido"); return
    mid=int(s)
    r=reservas.get(mid)
    if not r: print("no esta reservado"); return
    if r["user_id"]!=uid: print("no es tuyo"); return
    materiales[mid]["estado"]="disponible"
    del reservas[mid]
    print("devuelto")

def menu():
    while True:
        ubic=contexto["ubicacion"]
        pos = "almacen" if ubic["tipo"]=="almacen" else ("centro "+ubic["distrito"] if ubic["tipo"]=="centro" else f"actividad {ubic['actividad']} {ubic['distrito']}")
        user = f" | usuario {contexto['usuario']}" if contexto["usuario"] else ""
        print(f"Ubicacion: {pos}{user}")
        print("1 alta usuario")
        print("2 baja usuario")
        print("3 ver almacen")
        print("4 ver centro distrito")
        print("5 acceder actividad")
        print("6 listar materiales ubicacion")
        print("7 buscar material")
        print("8 reservar material")
        print("9 ver mis reservas")
        print("10 devolver material")
        print("11 salir")
        op=input("opcion 1 11: ").strip()
        if op=="1": alta_usuario()
        elif op=="2": baja_usuario()
        elif op=="3": acceder_almacen()
        elif op=="4": acceder_centro()
        elif op=="5": acceder_actividad()
        elif op=="6": listar_ubicacion()
        elif op=="7": buscar_material()
        elif op=="8": reservar()
        elif op=="9": ver_reservas()
        elif op=="10": devolver()
        elif op=="11": print("adios"); break
        else: print("opcion invalida")

if __name__=="__main__":
    seed()
    menu()
