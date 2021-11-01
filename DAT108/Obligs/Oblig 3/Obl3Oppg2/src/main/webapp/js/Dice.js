"use strict"
class Dice {

	constructor() {
		this.value = 0;


	}
	throw() {


		this.value = Math.floor(Math.random() * 6) + 1;
		return this.value;
	}

}


