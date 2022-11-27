import { Category } from "./category.model";
import { Customerproduct } from "./customerproduct.model";
import { Type } from "./type.model";

export class Device {
    deviceId?: number;
    model?: string;
    category?: Category;
    type?: Type;
    customerProductList?: Customerproduct[];
}
