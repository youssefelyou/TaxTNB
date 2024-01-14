import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/auth/auth.service";
import {AbstractService} from "./abs/abstract.service";
import {Taux} from "../model/taux.model";

@Injectable({
    providedIn: 'root'
})
export class TauxService extends AbstractService<Taux> {

    constructor(public http: HttpClient,
                private auth: AuthService) {
        super('taux/', auth, http);
    }

}
