// You can edit this function if you need the date in a different format
function format_date_field(y, m, d) {
   return '' + y + '-' + 
          ((m > 9) ? m : '0' + m) + '-' +
          ((d > 9) ? d : '0' + d);
}



m_list = Array("January", "February", "March",
               "April",   "May",      "June",
		       "July",    "August",   "September",
		       "October", "November", "December");	  
//target = '';
targets = Array();

function set_date_field(y, m, d, t_idx) {
   eval(targets[t_idx] + ' = unescape(\'' + escape(format_date_field(y, m, d)) + '\')' );
}

function show_cal(target_a) {
   var d = new Date();
   show_cal_m(d.getFullYear(), d.getMonth(), target_a);
}

function show_cal_m(y,m, target_a) {
   t_idx = targets.push(target_a) - 1;
   var x = (window.screenX || window.screenLeft || 0) + (500 || 0);
   var y = (window.screenY || window.screenTop || 0) + (300 || 0);  
   write_cal_pop(y,m, open('about:blank','cal_win'+t_idx,'width=175,height=150,'+'top=' +y+ ',left=' +x), t_idx);
}

function write_cal_pop(y,m, cal_win, t_idx) {
   cal_win.document.open();
   cal_win.document.writeln('<html><head><title>Date Picker</title>');
   cal_win.document.writeln('<style type="text/css">');
   cal_win.document.writeln('td {');
   cal_win.document.writeln('	font-family: Verdana, Arial, Helvetica, sans-serif;');
   cal_win.document.writeln('	font-size: 9pt;');
   cal_win.document.writeln('	color: #000000;');
   cal_win.document.writeln('	background-color: #CCCCCC;');
   cal_win.document.writeln('	text-align: center;');
   cal_win.document.writeln('}');
   cal_win.document.writeln('th {');
   cal_win.document.writeln('	font-family: Verdana, Arial, Helvetica, sans-serif;');
   cal_win.document.writeln('	font-size: 9pt;');
   cal_win.document.writeln('	color: #000000;');
   cal_win.document.writeln('	background-color: #CC0000;');
   cal_win.document.writeln('	text-align: center;');
   cal_win.document.writeln('}');
   cal_win.document.writeln('a {');
   cal_win.document.writeln('   color: #000000;');
   cal_win.document.writeln('   text-decoration: none;');
   cal_win.document.writeln('}');
   cal_win.document.writeln('</style></head><body leftmargin=2 topmargin=2 marginwidth=2 marginheight=2>');
   
   
   var one_day     = 1000 * 60 * 60 * 24;
   //var next_month  = (m==11) ? 0 : m + 1;
   
   d = new Date(y,m,1, 0,0,0,0);
   d = new Date(d.valueOf() - (one_day * 6));
   
   while (d.getDay() != 1) {
      d = new Date(d.valueOf() + one_day);
   }
   
   cal_win.document.writeln('<table align="center" width="100%" height="100%">');
   cal_win.document.writeln('<tr>'); 
   
   //PREV
   cal_win.document.write('<th><a href="javascript: opener.write_cal_pop(');
   if (m==0) {  cal_win.document.write((y-1) + ', 11'); } 
   else      {  cal_win.document.write(y + ', ' + (m-1)); }
   cal_win.document.writeln(', self, ' + t_idx + ');">&lt;</a></td>');
   
   //CUR.
   cal_win.document.writeln('<th colspan=5><b>' + m_list[m] + ' ' + y + '</b></td>');
   
   //NEXT
   cal_win.document.write('<th><a href="javascript: opener.write_cal_pop(');
   if (m==11) {  cal_win.document.write((y+1) + ', 0');    } 
   else       {  cal_win.document.write(y + ', ' + (m+1)); }
   cal_win.document.writeln(', self, ' + t_idx + ');">&gt;</a></td>');
   
   cal_win.document.writeln('</tr>'); 
   
   //day of week header
   cal_win.document.writeln('<tr><th>M</th><th>T</th><th>W</th><th>T</th><th>F</th><th>S</th><th>S</th></tr>');
   
   //DAYS
   day_count = 0;
   while (day_count < 42) {
      day_count++;
   
      if (d.getDay() == 1) { cal_win.document.writeln('<tr>'); }
      cal_win.document.writeln('<td>' + (d.getMonth()==m ? '<b>' : ''));
	  cal_win.document.writeln('<a href="javascript: opener.set_date_field(' +
	          d.getFullYear() + ', ' + (d.getMonth()+1) + ', ' + d.getDate() + 
			  ', ' + t_idx + '); self.close();">' +  d.getDate() + '</a>');
	  
      cal_win.document.writeln(d.getMonth()==m ? '</b></td>' : '</td>');
	  //next
      //d = new Date(d.valueOf() + one_day); //replaced to stop double day in oct error
	  d.setDate(d.getDate() + 1);
	  //if (d.getMonth() == next_month && d.getDay() == 1) {  break;  }
   }  
   cal_win.document.writeln('</table>');
   cal_win.document.writeln('</body></html>');
   cal_win.document.close();
}