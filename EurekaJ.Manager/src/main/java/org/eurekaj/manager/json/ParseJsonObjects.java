package org.eurekaj.manager.json;

import com.google.gson.Gson;
import org.eurekaj.manager.perst.alert.Alert;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IntelliJ IDEA.
 * User: jhs
 * Date: 12/21/10
 * Time: 8:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParseJsonObjects {

    public static Alert parseAlertJson(JSONObject jsonAlert) {
        Alert parsedAlert = null;

        if (jsonAlert.has("alertName")) {
            parsedAlert = new Alert();
            parsedAlert.setAlertName(parseStringFromJson(jsonAlert, "alertName"));
            parsedAlert.setWarningValue(parseIntegerFromJson(jsonAlert, "alertWarningValue").doubleValue());
            parsedAlert.setErrorValue(parseIntegerFromJson(jsonAlert, "alertErrorValue").doubleValue());
            parsedAlert.setGuiPath(parseStringFromJson(jsonAlert, "alertInstrumentationNode"));
            parsedAlert.setAlertDelay(parseIntegerFromJson(jsonAlert, "alertDelay"));
            parsedAlert.setActivated(parseBooleanFromJson(jsonAlert, "alertActivated"));
            parsedAlert.setSelectedAlertType(parseStringFromJson(jsonAlert, "alertType"));
            if (parsedAlert.getSelectedAlertType() == Alert.UNKNOWN) {
                parsedAlert.setSelectedAlertType(Alert.GREATER_THAN);
            }
        }
        return parsedAlert;
    }

    private static String parseStringFromJson(JSONObject json, String key) {
        String stringValue = null;

        try {
            stringValue = json.getString(key);
        } catch (JSONException e) {
            stringValue = null;
        }

        return stringValue;
    }

    private static Integer parseIntegerFromJson(JSONObject json, String key) {
        Integer intValue = null;
        try {
            intValue = Integer.parseInt(parseStringFromJson(json, key));
        } catch (NumberFormatException nfe) {
            intValue = null;
        }

        return intValue;
    }

    private static Boolean parseBooleanFromJson(JSONObject json, String key) {
        Boolean boolValue = null;

        try {
            boolValue = json.getBoolean(key);
        } catch (JSONException e) {
            boolValue = false;
        }

        return boolValue;
    }
}
