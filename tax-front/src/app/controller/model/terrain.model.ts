import {Redevable} from "./redevable.model";
import {Categorie} from "./categorie.model";

export class Terrain {
    public id: number
    public surface: number
    public nom: string
    public description: string
    public categorie: Categorie
    public redevable: Redevable
}
