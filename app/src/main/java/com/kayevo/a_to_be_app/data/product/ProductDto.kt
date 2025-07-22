package com.kayevo.a_to_be_app.data.product

import com.kayevo.a_to_be_app.domain.product.Product

data class ProductDto(val id: Int, val title: String)

fun List<ProductDto>.parseToProduct(): List<Product> = this.map { Product(
        id = it.id,
        title = it.title
    )
}
