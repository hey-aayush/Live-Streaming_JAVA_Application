package Client.Query;

import Client.EnumConstants.QueryCode;

import java.io.Serializable;

public abstract class Query implements Serializable {
        public abstract QueryCode getQueryCode();
}
