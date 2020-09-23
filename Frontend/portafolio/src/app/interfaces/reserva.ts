import { Time } from '@angular/common';

export interface Reserva {
    id : number;
    fecha : Date;
    hora : Time;
    id_u : number;
    servicio : string;
    ubicacion_f : string;
    estado : string;
    id_a : number;
}
