import { skill } from "./skill";

export interface Employee {
    id: number;
    name: string;
    salary: number;
    skills: skill[];
}