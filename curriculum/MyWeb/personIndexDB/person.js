export class Person{
 constructor(tname, taddress, phone){
    this.tname =tname;
    this.taddress  = taddress;
    this.phone   = phone ;
 }

 printInfo(){  
      console.log(`${this.tname}  ${this.taddress}   ${this.phone}`);
   }

 toString(){  
      return `${this.tname}  ${this.taddress}   ${this.phone}`;
   }

}