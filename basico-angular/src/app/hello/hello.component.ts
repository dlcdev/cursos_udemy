import {Component} from '@angular/core'

@Component({
  selector: 'hello',
  templateUrl: './hello.component.html'
})
export class HelloComponent {
  nome: string;
  clientes: Cliente[];

  constructor() {
    this.nome = "Paulo";
    let fulano = new Cliente("Fulano", 20);
    let cicrano = new Cliente("Cirano", 25);
    let outro = new Cliente("Outro", 32);
    this.clientes = [fulano, cicrano, outro];
  }
}

class Cliente {
  constructor(
    public nome: string,
    public idade: number
  ) {
  }
}
