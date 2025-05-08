function enMonthFormat(date){
  var month = new Date(date).getMonth()+1
  switch(month){
    case 1:
      month = "Jan"
      break
    case 2:
      month = "Feb"
      break
    case 3:
      month = "Mar"
      break
    case 4:
      month = "Apr"
      break
    case 5:
      month = "May"
      break
    case 6:
      month = "Jun"
      break
    case 7:
      month = "Jul"
      break
    case 8:
      month = "Aug"
      break
    case 9:
      month = "Sept"
      break
    case 10:
      month = "Oct"
      break
    case 11:
      month = "Nov"
      break
    case 12:
      month = "Dec"
  }
  return month
}

function monthAndDayformat(date) {
  var date = new Date(date);
  return `${date.getMonth() + 1}/${date.getDate()}`;
}

module.exports = {
  monthAndDayformat: monthAndDayformat,
  enMonthFormat: enMonthFormat
}


