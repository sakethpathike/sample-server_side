package com.saketh.sample.wallpapers

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson

//for frontend (sample)//
fun wallpapers() {
    val request =
        "https://api.imgur.com/3/gallery/Cq8rKRD".httpGet().header("Authorization", "Client-ID 58bcbf3f5ed49a1")
            .responseJson { _, _, result ->
                val descriptionArray = result.get().obj().getJSONObject("data").getJSONArray("images")
                for (count in 0 until descriptionArray.length()) {
                    val description = descriptionArray.getJSONObject(count).getString("description")
                    val imgUrl = descriptionArray.getJSONObject(count).getString("link")
                    // add ui elements
                }
            }
}
// description, link