
package com.sarvan.recyclerviewtest.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("status")
    public Integer status;

    @SerializedName("docs")
    public List<Doc> docs = null;

    public void setDocs(List<Doc> docs) {
        this.docs = docs;
    }

    public List<Doc> getDocs() {
        return docs;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
