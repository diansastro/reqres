package com.suitmedia.reqres.model

import com.google.gson.annotations.SerializedName

class SupportData(@SerializedName("url") var url: String? = "",
                  @SerializedName("text") var text: String? = "") {
}