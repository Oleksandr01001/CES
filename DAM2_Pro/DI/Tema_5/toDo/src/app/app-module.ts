import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Agregar } from './components/agregar/agregar';
import { Buscar } from './components/buscar/buscar';
import { FormsModule } from '@angular/forms';
import { Listar } from './components/listar/listar';

@NgModule({
  declarations: [
    App,
    Agregar,
    Buscar,
    Listar
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
  ],
  bootstrap: [App]
})
export class AppModule { }
