export class Pageable {
    public page: number;
    public size: number;


    constructor(page: number, size: number) {
        this.page = page;
        this.size = size;
    }
}