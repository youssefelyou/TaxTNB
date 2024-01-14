import {Taux} from "./taux.model";
import {Categorie} from "./categorie.model";
import {Redevable} from "./redevable.model";
import {Terrain} from "./terrain.model";

export class TaxeTNB {
    public id: number
    public total: number
    public tnbYear: number
    public montantBase: number
    public terrain: Terrain
    public redevable: Redevable
    public categorie: Categorie
    public taux: Taux
}
