import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthService} from "../../core/auth/auth.service";
import {AbstractService} from "./abs/abstract.service";
import {Categorie} from "../model/categorie.model";
import {TaxeTNB} from "../model/taxeTNB.model";

@Injectable({
    providedIn: 'root'
})
export class TaxeTNBService extends AbstractService<TaxeTNB> {

    constructor(public http: HttpClient,
                private auth: AuthService) {
        super('taxe/', auth, http);
    }

}
