// common.js

// Allows only numbers to be entered in an input field
// Usage: <input type="text" onkeypress="inputFilterNumbers(event);" />
function inputFilterNumbers(event) {
	var browser=navigator.appName;

	// This will get the ASCII code of the key presssed
	//
    var charCode = (event.charCode) ? event.charCode :
                   ((event.keyCode) ? event.keyCode :
                   ((event.which) ? event.which : 0));

	// If this is not a number and not backspace and not Ctrl key, supress it
	//
    if ((charCode > 57 || charCode < 48 ) && charCode != 8 && !event.ctrlKey) {

		// If Internet Exploder
		if (browser.indexOf("Microsoft") >= 0) {
			event.returnValue=false;
		}
		else {
			event.preventDefault();
		}
    }
}
//This function allows only numbers but it also allows symbol ".".This is mainly used to enter the dollar amount for bind page.
function inputFilterNumbersWithSymbol(event) {
	var browser=navigator.appName;

    var charCode = (event.charCode) ? event.charCode :
                   ((event.keyCode) ? event.keyCode :
                   ((event.which) ? event.which : 0));

    if ((charCode > 57 || charCode < 48 ) && charCode != 8 && !event.ctrlKey && charCode != 46 ) {
		if (browser.indexOf("Microsoft") >= 0) {
			event.returnValue=false;
		}
		else {
			event.preventDefault();
		}
    }
}

function isEmpty(inputStr)
{
  if(inputStr == null ||typeof(inputStr)=="undefined" || inputStr == "")
  {
	return true;
  }
  return false;
}

//Browser detection code
var IE4 = (document.all && !document.getElementById);
var NS4 = (document.layers);
var IE5 = (document.all && document.getElementById);
var N6 = (document.getElementById && !document.all);
//Browser detection code ends here

var aMonthNames = new Array(
	'JANUARY', 'FEBRUARY', 'MARCH',
	'APRIL', 'MAY', 'JUNE',
	'JULY',	'AUGUST', 'SEPTEMBER',
	'OCTOBER', 'NOVEMBER', 'DECEMBER'
	);
var aMonthDisplay = new Array(
	'01', '02', '03',
	'04', '05', '06',
	'07',	'08', '09',
	'10', '11', '12'
	);
var aMonthDays = new Array(
	/* Jan */ 31,     /* Feb */ 28, /* Mar */ 31,     /* Apr */ 30,
	/* May */ 31,     /* Jun */ 30, /* Jul */ 31,     /* Aug */ 31,
	/* Sep */ 30,     /* Oct */ 31, /* Nov */ 30,     /* Dec */ 31
	);
var days = new Array(42);

/*Comment2 starts
  This Function populates the table with the dates for a particular month in a year.
  comment2 ends*/
function daylayerdisplay(b,a,c)
{
	/*newwindow=window.open("");
	newwindow.status=b + "" + a + "" + c + "";*/
	/*Comment3 starts
	  b is Year in yyyy format
	  a is Months in numerical format viz 0=january,1=february etc
	  c is day in numeric format
	  Comment3 ends
	*/

	monthreduction=a;
	monthincrease=a;
    if (b%4 == 0 || b%100 ==0){
		aMonthDays[1]=29;
	}
	else{
		aMonthDays[1]=28;
	}
	var oDateNow = new Date();
	var oDate = new Date(aMonthNames[a] +  1 + "," + b);
	dayofweek=oDate.getDay();
	//Input values in td's
	var count=0;
	var count1;
	var end=aMonthDays[a]+(dayofweek);
	for (s=1;s<=42;s++){
		document.getElementById("day"+s).childNodes[0].innerHTML="";
	}
	for (s=(dayofweek+1);s<=end;s++){
		count=count+1;
		document.getElementById("day"+s).childNodes[0].innerHTML=count;
		if (count<=9)
		{
			count1=0+""+count;
		}
		else
		{
			count1=count;
		}
		document.getElementById("day"+s).childNodes[0].id=count1;
	}
}

/*Comment4 starts
This function sends the value back to the form object of the window
which called it*/
function sendvalue(y,m,d)
{
var dateOne = parent.document.forms[0].ddfield.value;
//alert (dateOne);
var monthOne = parent.document.forms[0].mmfield.value;
//alert (monthOne);
var yearOne = parent.document.forms[0].yyfield.value;
//alert (yearOne);
var cframeID = parent.document.forms[0].cfId.value;
//alert (y+' year');
	if (y == 1){
		todayobj= new Date();
		today=todayobj.getYear()+todayobj.getMonth()+todayobj.getDate();
		if (N6){
			year=todayobj.getYear()+1900;
		}
		else
		{
			year=todayobj.getYear();
		}
		if (todayobj.getDate() <= 9)
		{
			var todayday=0+""+todayobj.getDate();
		}
		else
		{
			var todayday=todayobj.getDate();
		}
		// parent.document.agentnotesform.receivedate.value=aMonthDisplay[todayobj.getMonth()]+ "-" + todayday + "-" + year;
		parent.document.getElementById(yearOne).value=year;
		parent.document.getElementById(dateOne).value=todayday;
		parent.document.getElementById(monthOne).value=aMonthDisplay[todayobj.getMonth()];
		parent.document.getElementById(cframeID).style.display='none';
	}
	else{
	// parent.document.agentnotesform.receivedate.value= aMonthDisplay[m]+"-"+d+"-"+y;//y + m + d;
	parent.document.getElementById(yearOne).value=y;
	parent.document.getElementById(dateOne).value=d;
	parent.document.getElementById(monthOne).value=aMonthDisplay[m];
	parent.document.getElementById(cframeID).style.display='none'
	}
	parent.document.getElementById(yearOne).focus();
}
/*Comment4 ends here*/


function closeFrame()
{

  var cframeID = parent.document.forms[0].cfId.value;

	parent.document.getElementById(cframeID).style.display='none';

}

/*Comment5 starts
This function reduces the month by one everytime prev.gif is clicked*/
function reducemonths()
{
	 monthreduction= +monthreduction - 1;
	 if (monthreduction==-1)
	 {
		 monthreduction=11;
		 document.calendarform.year.value=parseFloat(document.calendarform.year.value)-1;
	 }

	 document.calendarform.month[monthreduction].selected = "1";
	 daylayerdisplay(document.calendarform.year.value,monthreduction,101);
}
/*Comment5 ends here*/

/*Comment6 starts
This function Increases the month by one everytime next.gif is clicked*/
function increasemonths()
{
	monthincrease= +monthincrease + 1;
	if (monthincrease==12)
	{
		 monthincrease=0;
		 document.calendarform.year.value=
		 parseFloat(document.calendarform.year.value)+1;
	}
	document.calendarform.month[monthincrease].selected = "1";
	daylayerdisplay(document.calendarform.year.value,monthincrease,101);
}
/*Comment6 ends here*/

function submitAndClosePopUp(url){
	parent.location=url;
	self.close();
}

function setSubmitMethod(value) {
	var field = getElementById("methodid");
	if (field != null) {
		field.name = "method";
		setInputValue(field, value);
	}
}

function submitFormWithMethod(form, methodValue) {
	var methodIdField;

	if (form != null) {
		methodIdField = form.elements["methodid"];
		if (methodIdField != null) {
			methodIdField.name = "method";
			setInputValue(methodIdField, methodValue);
			submitForm(form);
		}
	}
}

var validator = new ValidatorObject();

function ValidatorObject() {
	var lastHighlightedField;
	var lastBackgroundColor;
	var highlightBGColor = "yellow";

	// constructor
	init();

	this.init =
		function init() {};

	// public method
	this.onClickError =
		function onClickError(invalidFieldName) {
			var invalidField = document.getElementById(invalidFieldName);

			if (invalidField != null) {
				if (lastHighlightedField != null) {
					lastHighlightedField.style.backgroundColor=lastBackgroundColor;
				}
				lastHighlightedField = invalidField;
				lastBackgroundColor=invalidField.style.backgroundColor;
				invalidField.style.backgroundColor=highlightBGColor;
				invalidField.focus();
			}
		};
}

function dtFieldNames(dd,mm,yyyy,cf)
{
	document.forms[0].ddfield.value = dd;
	document.forms[0].mmfield.value = mm;
	document.forms[0].yyfield.value = yyyy;
	document.forms[0].cfId.value = cf;
}

function getContextPath()
{
	var myLocation = location.href;
	var myLocArray = myLocation.split("/");
	var myContextPath = "";
	for(var p=0; p<4 && p<myLocArray.length; p++)
		myContextPath += myLocArray[p] + "/";
	return myContextPath;
}

// Checks for status code and request type of CR or LIS or MVR and disables the form controls accordingly.
function checkStatusAndDisable() {
	// Enable everything for the submit
	var box = document.forms[0].elements;
	for(var i=0;i<box.length;i++)
	{
		box[i].disabled = false;
	}
	// Order CR
	if (document.getElementById('lastCRStatusCd') != null) {
		if ( (document.getElementById('lastCRRequestType').value=="Interactive") && (document.getElementById('lastCRStatusCd').value == "Pending") ) {
			//Disable all the buttons of the form.
			for (i = 0; i < document.forms[0].elements.length; i++) {
				if ( document.forms[0].elements[i].type == "button" ) {
					document.forms[0].elements[i].disabled = true;
				}
			}
			// Disable all the links
			for (i=0; i<document.links.length; i++) {
				document.links[i].href="#";
			}
		}
	// Order LIS
	}else if (document.getElementById('lastLISStatusCd') != null) {
		if ( (document.getElementById('lastLISRequestType').value=="Interactive") && (document.getElementById('lastLISStatusCd').value == "Pending") ) {
			for (i = 0; i < document.forms[0].elements.length; i++) {
				if ( document.forms[0].elements[i].type == "button" ) {
					document.forms[0].elements[i].disabled = true;
				}
			}
			for (i=0; i<document.links.length; i++) {
				document.links[i].href="#";
			}
		}
	// Order MVR
	}else if (document.getElementById('lastMVRStatusCd') != null) {
		if ( (document.getElementById('lastMVRRequestType').value=="Interactive") && (document.getElementById('lastMVRStatusCd').value == "Pending") ) {
			for (i = 0; i < document.forms[0].elements.length; i++) {
				if ( document.forms[0].elements[i].type == "button" ) {
					document.forms[0].elements[i].disabled = true;
				}
			}
			for (i=0; i<document.links.length; i++) {
				document.links[i].href="#";
			}
		}
  	}
}

//Simple Show Layer Function
function showLayer(theLayer)
{
	var theLayerRef = document.getElementById(theLayer);
	if (theLayerRef!=null)
		theLayerRef.style.display = "block";
}

//Simple Show Layer Function
function hideLayer(theLayer)
{
	var theLayerRef = document.getElementById(theLayer);
	if (theLayerRef!=null)
		theLayerRef.style.display = "none";
}

	// *** IMP: This logic needs to be updated whenever ShowHouseNonDriverExcludedReason logic changes.
	/***
		excludedDriverLabelLayer - Layer id of the Reason for Excluded Driver.
		excludedDriverDropdownLayer - Layer id of the dropdown.
	***/
	/*
	function relationToPrimaryUpdates(theValue, count)
	{
		var ratingState = document.getElementById('rState').value;
		var lineType = document.getElementById('line').value;
		var labelLayer = 'excludedDriverLabelLayer'+count;
		var dropDownLayer = 'excludedDriverDropdownLayer'+count;
		//  	 Defect Fix by Infosys - alndb00141777- Start
		var excludedReasonCd = document.getElementById("driverInfo["+count+"].excludedReasonCd");
		//  	 Defect Fix by Infosys - alndb00141777- end

		if ( (document.getElementById(labelLayer)!=null) && (document.getElementById(dropDownLayer)!=null)) {
			if (ratingState != 'CA') {
				if (theValue == 'SP')  {
					hideLayer(labelLayer);
					hideLayer(dropDownLayer);
		//   	Defect Fix by Infosys - alndb00141777- Start
		//	This fix is to blank out the excluded driver reason code field when the Relation to Primary is Spouse.
					if(excludedReasonCd != null){
					excludedReasonCd.value="";
					}
		//   	Defect Fix by Infosys - alndb00141777- end
				}else {
					showLayer(labelLayer);
					showLayer(dropDownLayer);
				}
			}
			else {
				showLayer(labelLayer);
				showLayer(dropDownLayer);
			}
			if (lineType == '019')	{
				if ( (ratingState=='CT') || (ratingState=='CA') || (ratingState=='WA') || (ratingState=='OH') || (ratingState=='IL') )
					showLayer(labelLayer);
					showLayer(dropDownLayer);
			}
		}
	}
	*/

