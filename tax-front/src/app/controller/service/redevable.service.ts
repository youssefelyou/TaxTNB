import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/auth/auth.service";
import {AbstractService} from "./abs/abstract.service";
import {Redevable} from "../model/redevable.model";

@Injectable({
    providedIn: 'root'
})
export class RedevableService extends AbstractService<Redevable> {

    constructor(public http: HttpClient,
                private auth: AuthService) {
        super('redevable/', auth, http);
    }

}
