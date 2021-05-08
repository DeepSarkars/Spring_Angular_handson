import { Department } from "./department";
import { Skill } from "./skill";

export class Employee{
    constructor(
        public id: Number,
        public name: String,
        public salary: Number,
        public permanent: Boolean,
        public department: Department,
        public dob: String
    ){}
}