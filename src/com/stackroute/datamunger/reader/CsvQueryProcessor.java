package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {
	String filenm;

	// parameterized constructor to initialize filename
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
		filenm = fileName;
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file. Note: Return type of the method will be
	 * Header
	 */
	@Override
	public Header getHeader() throws IOException {

		// read the first line

		// populate the header object with the String array containing the
		// header names
		FileReader fileReader = new FileReader(filenm);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		// read the first line
		String headerRow = bufferedReader.readLine();
		bufferedReader.close();
		fileReader.close();
		// populate the header object with the String array containing the
		// header names
		String[] headers = headerRow.split(",");
		Header header = new Header();
		header.setHeaders(headers);
		return header;
	}

	/**
	 * getDataRow() method will be used in the upcoming assignments
	 */

	/*
	 * implementation of getColumnType() method. To find out the data types, we
	 * will read the first line from the file and extract the field values from
	 * it. If a specific field value can be converted to Integer, the data type
	 * of that field will contain "java.lang.Integer", otherwise if it can be
	 * converted to Double, then the data type of that field will contain
	 * "java.lang.Double", otherwise, the field is to be treated as String.
	 * Note: Return Type of the method will be DataTypeDefinitions
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		String[] colunmType = null;
		List<String> recordColumns = new ArrayList<String>();
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filenm)))) {
			int columnNumbers = bufferedReader.readLine().split(",").length;

			String columnHeader = bufferedReader.readLine();
			String columnHeaders[] = columnHeader.split(",", -1);
			colunmType = new String[columnNumbers];
			int index = 0;
			for (String recordcolumn : columnHeaders) {
				// recordcolumn = dataTypeIdentification(recordcolumn);
				try {
					int recValue = Integer.parseInt(recordcolumn);
					Object object = (Object) recValue;
					recordColumns.add(object.getClass().getName());
				} catch (NumberFormatException numberFormatException) {
					try {
						double recValue = Double.parseDouble(recordcolumn);
						Object object = (Object) recValue;
						recordColumns.add(object.getClass().getName());
					} catch (NumberFormatException numberFormatException2) {
						Object object = (Object) recordcolumn;
						recordColumns.add(object.getClass().getName());
					}
				}
			}
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}
		String columnDataType[] = new String[recordColumns.size()];

		recordColumns.toArray(columnDataType);
		DataTypeDefinitions dataTypeDefinitions = new DataTypeDefinitions();
		dataTypeDefinitions.setDataTypes(columnDataType);
		return dataTypeDefinitions;
	}

	@Override
	public void getDataRow() {
		// TODO Auto-generated method stub

	}
}