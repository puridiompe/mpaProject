/**
 * 
 */
package com.puridiompe.mpa.common.json;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.puridiompe.mpa.common.type.Datetime;

/**
 * @author Johnny
 *
 */
public class DatetimeDeserializer extends JsonDeserializer<Datetime> {

	private static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public Datetime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = p.getCodec();
		TextNode node = (TextNode) oc.readTree(p);
		String dateString = node.textValue();
		Datetime result = null;
		try {
			result = new Datetime(DATE_TIME_FORMAT.parse(dateString));
		} catch (ParseException e) {
			//Logger.error(this, e);
			//TODO: Inject logger object
			e.printStackTrace();
		}

		return result;
	}

}
