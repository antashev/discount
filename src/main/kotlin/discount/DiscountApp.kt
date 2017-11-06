package discount

import discount.domain.DiscountImpact
import discount.domain.Impact
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.gson
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.text.DateFormat

/**
 * Created by ilya on 05.11.17.
 */
fun Application.main() {
    install(DefaultHeaders)
    install(Compression)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setDateFormat(DateFormat.LONG)
            setPrettyPrinting()
        }
    }
    val impact = Impact("first-1", listOf(DiscountImpact("10", "PERSENT")))
    routing {
        get("/v1/impact") {
            call.respond(impact)
        }
        get("/") {
            call.respondText("My Example of Discount System", ContentType.Text.Html)
        }
    }
}
