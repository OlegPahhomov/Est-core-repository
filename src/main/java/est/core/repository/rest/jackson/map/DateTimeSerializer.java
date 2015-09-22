package est.core.repository.rest.jackson.map;

import java.io.IOException;

import org.joda.time.DateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import est.core.repository.utils.DateUtils;

public class DateTimeSerializer extends JsonSerializer<DateTime> {

    @Override
    public void serialize(DateTime date, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeString(DateUtils.toJson(date));
    }
}
