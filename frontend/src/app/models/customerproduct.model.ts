import { Customer } from "./customer.model";
import { Device } from "./device.model";
import { Task } from "./task.model";

export class Customerproduct {
    customerProductId?: number;
    serialNumber?: string;
    customer?: Customer;
    device?: Device;
    taskList?: Task[];
}

