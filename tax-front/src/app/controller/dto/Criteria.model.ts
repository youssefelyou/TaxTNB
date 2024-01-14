export class Criteria<T> {
    public content: Array<T>;
    public last: boolean
    public totalPages: number
    public totalElements: number
    public size: number = 9
    public number: number
    public first: boolean
    public numberOfElements: number
    public empty: boolean
}
