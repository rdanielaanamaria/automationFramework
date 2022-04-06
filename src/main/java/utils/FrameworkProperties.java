package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = ""; /*this will be the initial value that is going to be retrieved from the file */
    private InputStream inputStream; /*to read the file*/

    public String getProperty (String key) { /* whenever we want to get a value from the file we call this method
    and we supply the key*/
        try {
            Properties properties = new Properties();
            String propFileName = Constants.PROP_FILE_NAME; /*"framework.properties"; store the file name of property
             file*/

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
                properties.load(inputStream);
            else
                throw new FileNotFoundException(Constants.FILE_NOT_FOUND_EXCEPTION_MESSAGE);  /* instead of ("The " +
                        "property file has nont been found");*/

            String propertyValue = properties.getProperty(key);
            this.result = propertyValue;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
