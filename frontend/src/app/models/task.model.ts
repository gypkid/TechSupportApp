import { Customerproduct } from "./customerproduct.model";
import { Note } from "./note.model";
import { User } from "./user.model";

export class Task {
    taskId?: number;
    date?: Date;
    title?: Text;
    noteList?: Note[];
    status?: boolean;
    customerProduct?: Customerproduct;
    user?: any;
}
