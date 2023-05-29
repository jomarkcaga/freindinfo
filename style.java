function doPost(e) {
  try {
    var sheet = SpreadsheetApp.openById('YOUR_SPREADSHEET_ID').getActiveSheet();
    var headers = sheet.getRange(1, 1, 1, sheet.getLastColumn()).getValues()[0];
    var newRow = headers.map(function(header) {
      return e.parameter[header] || '';
    });
    sheet.appendRow(newRow);
    return ContentService.createTextOutput('Success');
  } catch (error) {
    return ContentService.createTextOutput('Error: ' + error.message);
  }
}
