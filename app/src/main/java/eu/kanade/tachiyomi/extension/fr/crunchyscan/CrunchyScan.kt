package eu.kanade.tachiyomi.extension.fr.crunchyscan

import eu.kanade.tachiyomi.source.online.HttpSource
import eu.kanade.tachiyomi.network.GET
import eu.kanade.tachiyomi.network.asObservableSuccess
import okhttp3.Response
import rx.Observable

class CrunchyScan : HttpSource() {

    override val name = "CrunchyScan"
    override val baseUrl = "https://crunchyscan.fr"
    override val lang = "fr"
    override val supportsLatest = true

    // 📌 Page principale (populaire)
    override fun popularMangaRequest(page: Int) =
        GET("$baseUrl/lecture-en-ligne/page/$page")

    override fun popularMangaParse(response: Response) =
        throw Exception("Parsing à compléter selon le site")

    // 📌 Recherche
    override fun searchMangaRequest(page: Int, query: String, filters: com.github.salomonbrys.kotson.jsonObject) =
        GET("$baseUrl/?s=$query&post_type=wp-manga")

    override fun searchMangaParse(response: Response) =
        throw Exception("Parsing à compléter selon le site")

    // 📌 Chapitres
    override fun chapterListRequest(manga: eu.kanade.tachiyomi.source.model.SManga) =
        GET(manga.url)

    override fun chapterListParse(response: Response) =
        throw Exception("Parsing à compléter selon le site")

    // 📌 Pages
    override fun pageListRequest(chapter: eu.kanade.tachiyomi.source.model.SChapter) =
        GET(baseUrl + chapter.url)

    override fun pageListParse(response: Response) =
        throw Exception("Parsing à compléter selon le site")

    override fun imageUrlParse(response: Response) =
        throw Exception("Parsing à compléter selon le site")
}
