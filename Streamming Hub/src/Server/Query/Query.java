package Server.Query;

import Server.EnumConstants.QueryCode;

import java.io.Serializable;

public abstract class Query implements Serializable {
        public abstract QueryCode getQueryCode();
}
