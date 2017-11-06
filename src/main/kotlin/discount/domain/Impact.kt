package discount.domain

/**
 * Created by ilya on 06.11.17.
 */
data class Impact(
        val id: String,
        val impacts: List<PositionImpact>
)

interface PositionImpact

class DiscountImpact(
        val value: String,
        val type: String
): PositionImpact