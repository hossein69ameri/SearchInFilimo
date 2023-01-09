package com.example.filimosearch.data.model


import com.google.gson.annotations.SerializedName

data class ResponseSearch(
    @SerializedName("data")
    val `data`: List<Data>?
) {
    data class Data(
        @SerializedName("attributes")
        val attributes: Attributes?,
        @SerializedName("id")
        val id: Int?, // 114864
        @SerializedName("type")
        val type: String? // suggestion
    ) {
        data class Attributes(
            @SerializedName("age_range")
            val ageRange: String?, // 18-99
            @SerializedName("audio")
            val audio: Audio?,
            @SerializedName("avg_rate_label")
            val avgRateLabel: String?, // 89%
            @SerializedName("badge")
            val badge: Badge?,
            @SerializedName("categories")
            val categories: List<Category?>?,
            @SerializedName("commingsoon_txt")
            val commingsoonTxt: String?,
            @SerializedName("countries")
            val countries: List<Country?>?,
            @SerializedName("cover")
            val cover: Any?, // null
            @SerializedName("descr")
            val descr: String?, // دیوید بکام: نامی که همه آن را می شناسند، اسطوره فوتبال و زمانی منفورترین مرد انگلستان. بکام که به راستی نابغه فوتبال مدرن است، سرآغازی ساده در فوتبال داشت و توانست عنوان پربازی ترین بازیکن ملی را به دست بیاورد، در یک فصل همراه باشگاهش برنده سه جام شود، گران قیمت ترین بازیکن تمام دوران ها شود و در تیم هایی مثل منچستر یونایتد، رئال مادرید و آ ث میلان بازی کند.
            @SerializedName("director")
            val director: Any?, // null
            @SerializedName("dubbed")
            val dubbed: Dubbed?,
            @SerializedName("duration")
            val duration: Duration?,
            @SerializedName("freemium")
            val freemium: Boolean?, // false
            @SerializedName("HD")
            val hD: Boolean?, // false
            @SerializedName("imdb_rate")
            val imdbRate: String?, // 4.50
            @SerializedName("language_info")
            val languageInfo: LanguageInfo?,
            @SerializedName("last_watch")
            val lastWatch: List<Any?>?,
            @SerializedName("link_key")
            val linkKey: String?, // hd8y4
            @SerializedName("link_type")
            val linkType: String?, // movie
            @SerializedName("movie_id")
            val movieId: String?, // 114864
            @SerializedName("movie_title")
            val movieTitle: String?, // دیوید بکام: بدنام
            @SerializedName("movie_title_en")
            val movieTitleEn: String?, // David Beckham: Infamous
            @SerializedName("output_type")
            val outputType: String?, // movie
            @SerializedName("pic")
            val pic: Pic?,
            @SerializedName("position")
            val position: Int?, // 1
            @SerializedName("pro_year")
            val proYear: String?, // 2022
            @SerializedName("publish_date")
            val publishDate: String?, // 2022-04-18 00:00:00
            @SerializedName("rate_avrage")
            val rateAvrage: String?, // 4.44
            @SerializedName("rate_enable")
            val rateEnable: Boolean?, // true
            @SerializedName("rate_enable_by_cnt")
            val rateEnableByCnt: Boolean?, // true
            @SerializedName("rel_data")
            val relData: RelData?,
            @SerializedName("serial")
            val serial: Serial?,
            @SerializedName("sid")
            val sid: Int?, // 0
            @SerializedName("subtitle")
            val subtitle: Subtitle?,
            @SerializedName("tag_id")
            val tagId: Any?, // null
            @SerializedName("theme")
            val theme: String?, // thumbnail
            @SerializedName("uid")
            val uid: String?, // hd8y4
            @SerializedName("uuid")
            val uuid: String?, // 47d240a4a37b4e69930e19bb4cd26639
            @SerializedName("watch_list_action")
            val watchListAction: String?, // login
            @SerializedName("watermark")
            val watermark: Boolean? // false
        ) {
            data class Audio(
                @SerializedName("isMultiLanguage")
                val isMultiLanguage: Boolean?, // false
                @SerializedName("languages")
                val languages: List<String?>?
            )

            data class Badge(
                @SerializedName("backstage")
                val backstage: Boolean?, // false
                @SerializedName("commingsoon")
                val commingsoon: Boolean?, // false
                @SerializedName("exclusive")
                val exclusive: Boolean?, // false
                @SerializedName("free")
                val free: Boolean?, // false
                @SerializedName("hear")
                val hear: Boolean?, // false
                @SerializedName("info")
                val info: List<Any?>?,
                @SerializedName("online_release")
                val onlineRelease: Boolean?, // false
                @SerializedName("vision")
                val vision: Boolean? // false
            )

            data class Category(
                @SerializedName("link_key")
                val linkKey: String?, // documentary
                @SerializedName("link_type")
                val linkType: String?, // list
                @SerializedName("title")
                val title: String?, // مستند
                @SerializedName("title_en")
                val titleEn: String? // documentary
            )

            data class Country(
                @SerializedName("country")
                val country: String?, // انگلیس
                @SerializedName("country_en")
                val countryEn: String? // england
            )

            data class Dubbed(
                @SerializedName("enable")
                val enable: Boolean?, // false
                @SerializedName("text")
                val text: String?
            )

            data class Duration(
                @SerializedName("text")
                val text: String?, // یک ساعت و 8 دقیقه
                @SerializedName("value")
                val value: Int? // 4127
            )

            data class LanguageInfo(
                @SerializedName("flag")
                val flag: String?, // hasSubtitle
                @SerializedName("text")
                val text: String? // زیرنویس دارد
            )

            data class Pic(
                @SerializedName("movie_img_b")
                val movieImgB: String?, // https://static.cdn.asset.filimo.com/flmt/mov_114864_33369-b.jpg
                @SerializedName("movie_img_m")
                val movieImgM: String?, // https://static.cdn.asset.filimo.com/flmt/mov_114864_33369-m.jpg
                @SerializedName("movie_img_s")
                val movieImgS: String? // https://static.cdn.asset.filimo.com/flmt/mov_114864_33369-s.jpg
            )

            data class RelData(
                @SerializedName("rel_id")
                val relId: Any?, // null
                @SerializedName("rel_title")
                val relTitle: Any?, // null
                @SerializedName("rel_type")
                val relType: Any?, // null
                @SerializedName("rel_type_txt")
                val relTypeTxt: String?,
                @SerializedName("rel_uid")
                val relUid: Any? // null
            )

            data class Serial(
                @SerializedName("enable")
                val enable: Boolean?, // false
                @SerializedName("last_part")
                val lastPart: String?,
                @SerializedName("parent_title")
                val parentTitle: String?,
                @SerializedName("part_text")
                val partText: String?,
                @SerializedName("season_id")
                val seasonId: Int?, // 0
                @SerializedName("season_text")
                val seasonText: String?,
                @SerializedName("serial_part")
                val serialPart: String?
            )

            data class Subtitle(
                @SerializedName("enable")
                val enable: Boolean?, // false
                @SerializedName("text")
                val text: String?
            )
        }
    }
}