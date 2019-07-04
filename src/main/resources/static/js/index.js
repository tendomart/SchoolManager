
//This contains validation Rules and other functions.

// ES6 Modules or TypeScript
import Swal from 'sweetalert2'

import Swal from 'sweetalert2/dist/sweetalert2.js'

import 'sweetalert2/src/sweetalert2.scss'

// CommonJS
const Swal = require('sweetalert2')

function validate(){
	  let name=document.getElementById('name').value;
	let pswd = document.getElementById('password').value;
	
	if(name==""){
		alert('Sorry You didnot enter a Name')
		return;
	}
	
	if(pswd==""){
		alert('Sorry You didnot enter a Name')
		return;
	}

return true;
}

function success(){
	let validate =validate();
	if(validate==true){
		let alty =document.getElementByClass('w3-container w3-red');
		return alty;
	}
}

function swal123(){
	let pswd = document.getElementById('password').value;
	
	swal({
		title: 'Congratulations!',
		text: 'Your message has been succesfully sent',
		type: 'success'
		});
}


var cursor = document.getElementById("input[type=text]" );
if (cursor)  setCaretPosition(cursor, 20);