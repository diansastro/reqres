package com.suitmedia.reqres.data.response

import com.google.gson.annotations.SerializedName
import com.suitmedia.reqres.model.SupportData
import com.suitmedia.reqres.model.GuestData

class GuestResponse(@SerializedName("page") var page: Int? = 0,
                    @SerializedName("per_page") var per_page: Int? = 0,
                    @SerializedName("total") var total: Int? = 0,
                    @SerializedName("total_pages") var total_pages: Int? = 0,
                    @SerializedName("data") var data: ArrayList<GuestData>,
                    @SerializedName("support") var support: SupportData? = null) {
}