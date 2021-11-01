"use strict"
class Controller {

	constructor(root) {

		this.root = root;
		this.run = this.run.bind(this);
		this.rollDice = this.rollDice.bind(this);


	}

	rollDice() {

		const dice = new Dice();
		const res = document.getElementById(this.root).querySelector("[data-diceoutput]");
		res.innerHTML = dice.throw();

	}

	run() {

		const btRef = document.getElementById(this.root).getElementsByTagName("button")[0];
		btRef.addEventListener("click", this.rollDice, true);

	}


}

const DiceController = new Controller("root");
document.addEventListener("DOMContentLoaded", DiceController.run(), true);

