//import React from 'react';

//import React, { useState } from 'react';
//export default function Survey(props) {
  //  const { classes, url } = props;
    //let [clicks, setClicks] = useState(0);
    //const submit = function (event) {
      //  console.log(event.currentTarget.getAttribute('data-something'));
        //setClicks(clicks + 1);
    //}
    //return (
      //  <React.Fragment>
        //    <p>Hi there!</p>
          //  <p>hello count:{clicks}</p>
            //<button onClick={submit} data-something="Default">
              //  Default</button>
        //</React.Fragment>
     //);
//}

class Survey extends React.Component {
	render() {
		return(
	
	</head>
	<body onload="focus()">
		<p>
		Assignment 6
		</br>
		Developed by: Satyasaarika Putla, Vandana Keshavamurthy
		</br>
		For our collaboration summary, click
		<a href="http://mason.gmu.edu/~sputla2">here</a>
		<h1 align="center">George Mason Bookstore Ratings</h1>
		This website allows students in the Volgenau School of Engineering to rate the George Mason Bookstore, Barnes and Noble, based on their 			experiences with buying textbooks. </p>
		<form id="bookstorerating" method="post" action="asst6" name="UserInfo" onSubmit="return (CheckInput())">
			<table>	
				<tbody>
					<tr>
						<td style="margin: 5px; padding: 5px;">Major:
						</td>
						<td>
							<input type="text" name="Major">
						</td>
					</tr>
					<tr>
						<td>Year:
							</td>
						<td>
							<input type="text" name="Year">
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			1. How easy was it for you to find your textbooks in the store?
			<br>
			<input type="radio" name="Q1" id="Very Easy" value="Very Easy"/>
			<label for="Very Easy">Very Easy</label>
			<br/>
			<input type="radio" name="Q1" id="Easy" value="Easy"/>
			<label for="Easy">Easy</label>
			<br/>
			<input type="radio" name="Q1" id="Hard" value="Hard"/>
			<label for="Hard">Hard</label>
			<br/>
			<input type="radio" name="Q1" id="Very Hard" value="Very Hard"/>
			<label for="Very Hard">Very Hard</label>
			<br/>
			<br>
			2. How many times were the textbooks you needed (digital or hard copy) out of stock?
			<br>
			<input type="radio" name="Q2" id="Never" value="Never"/>
			<label for="Never">Never</label>
			<br/>
			<input type="radio" name="Q2" id="1-3 times" value="1-3 times"/>
			<label for="1-3 times">1-3 times</label>
			<br/>
			<input type="radio" name="Q2" id="4-6 times" value="4-6 times"/>
			<label for="4-6 times">4-6 times</label>
			<br/>
			<input type="radio" name="Q2" id="7 or more times" value="7 or more times"/>
			<label for="7 or more times">7 or more times</label>
			<br/>
			<br>
			3. How reasonable do you think the textbook prices were compared to other sellers?
			<br>
			<input type="radio" name="Q3" id="Very Reasonable" value="Very Reasonable"/>
			<label for="Very Reasonable">Very Reasonable</label>
			<br/>
			<input type="radio" name="Q3" id="Reasonable" value="Reasonable"/>
			<label for="Reasonable">Reasonable</label>
			<br/>
			<input type="radio" name="Q3" id="Expensive" value="Expensive"/>
			<label for="Expensive">Expensive</label>
			<br/>
			<input type="radio" name="Q3" id="Very Expensive" value="Very Expensive"/>
			<label for="Very Expensive">Very Expensive</label>
			<br/>
			<br>
			4. If given the option, do you prefer digital or hard copy textbooks? 
			<br>
			<input type="radio" name="Q4" id="Yes" value="Yes"/>
			<label for="Yes">Yes</label>
			<br/>
			<input type="radio" name="Q4" id="No" value="No"/>
			<label for="No">No, I prefer using hard copies for these classes</label>
			<br/>
			<input type="radio" name="Q4" id="Depends" value="Depends"/>
			<label for="Depends">Depends on the class</label>
			<br/>
			<br>
			5. How accurate are the recommended and required textbook lists that the bookstore provides online?
			<br>
			<input type="radio" name="Q5" id="Very Accurate" value="Very Accurate"/>
			<label for="Very Accurate">Very Accurate, used all textbooks frequently</label>
			<br/>
			<input type="radio" name="Q5" id="Accurate" value="Accurate"/>
			<label for="Accurate">Somewhat Accurate, occasionally used some textbooks</label>
			<br/>
			<input type="radio" name="Q5" id="Not Accurate" value="Not Accurate"/>
			<label for="Not Accurate">Not Accurate, never used any textbooks</label>
			<br>
			<p> Additional Comments, Suggestions, and Concerns:</p>
			<textarea id="textArea" name="Comments" rows="6" cols="40"></textarea>
			<br/>
			<br/>
			<button type="submit"onclick="submitSuccess()" style="width: 10%; height: 4%; font-size: 13px;">Submit Answers</button>
			<br/>
			<br/>
		</form>
	</body>
	);
	}
}
ReactDOM.render(<Survey />, document.getElementById('root'));


function focus() { 
	document.UserInfo.Major.focus()
}
function IsNum (string) {
	var value = parseInt (string);
	return (value > 0);
}
function CheckInput() {
	var ErrorMessage = '';
	var NumErrors = 0;
	var Major = document.UserInfo.Major;
	if (IsNum(Major.value)) { 
		NumErrors++;
		ErrorMessage += '\n' + NumErrors + ') Major should be a valid name, not a number. For example: CS, SWE, IT, etc.';
	}
	if (Major.value == '')
    {
		NumErrors++;
		ErrorMessage += '\n' + NumErrors + ') Missing major. ';
	}
	var Year = document.UserInfo.Year;
	if (!IsNum(Year.value)) { 
		NumErrors++;
		ErrorMessage += '\n' + NumErrors + ') Year should be an integer (ex: 1 = Freshman, 2 = Sophomore, etc.). ';
	}
	if (Year.value == '')
    {
		NumErrors++;
		ErrorMessage += '\n' + NumErrors + ') Missing year.  ';
	}
	if (NumErrors > 0)
	{
		alert('Please correct the errors below and resubmit:  ' + ErrorMessage);
		return (false);
	}
	else
	{
		alert('Your responses have been saved. Thank you for your feedback!');
		return (true);
	}
}


