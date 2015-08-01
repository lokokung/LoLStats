package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import riotapi.exceptions.BadRequestException;
import riotapi.exceptions.DataNotFoundException;
import riotapi.exceptions.InternalServerException;
import riotapi.exceptions.RateLimitException;
import riotapi.exceptions.UnauthorizedException;
import riotapi.exceptions.UnavailableException;

public class URLHandler {
    public URLHandler() {
    }

    public void handleExceptions(int code) throws BadRequestException,
            UnauthorizedException, RateLimitException, InternalServerException,
            UnavailableException, DataNotFoundException {
        if (code == 400)
            throw new BadRequestException();
        if (code == 401)
            throw new UnauthorizedException();
        if (code == 404)
            throw new DataNotFoundException();
        if (code == 429)
            throw new RateLimitException();
        if (code == 500)
            throw new InternalServerException();
        if (code == 503)
            throw new UnavailableException();
    }

    public InputStream requestGetInputStream(String url) throws Exception {
        HttpURLConnection conn = null;
        int responseCode = -1;
        try {
            URL httpRequest = new URL(url);
            conn = (HttpURLConnection) httpRequest.openConnection();
            conn.setRequestMethod("GET");
            responseCode = conn.getResponseCode();
        } catch (Exception e) {
            return null;
        }

        handleExceptions(responseCode);
        return conn.getInputStream();
    }

    public String requestGetString(String url) throws Exception {
        InputStream stream = requestGetInputStream(url);
        return getStringFromStream(stream);
    }

    public String getStringFromStream(InputStream stream) {
        if (stream != null) {
            StringWriter writer = new StringWriter();
            try {
                IOUtils.copy(stream, writer);
            } catch (IOException e) {
                return null;
            } finally {
                try {
                    stream.close();
                } catch (IOException e) {
                }
            }
            return writer.toString();
        }
        return null;
    }

    public boolean writeStringToFile(String toWrite, File fileDestination) {
        FileWriter output = null;
        boolean written = false;
        try {
            output = new FileWriter(fileDestination);
            output.write(toWrite);
            output.flush();
            written = true;
        } catch (IOException e) {
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                }
            }
        }
        return written;
    }
}
