package com.example.indexer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookRestTemplateService{

    private static final String INDEX = "book";

    private ElasticsearchOperations elasticsearchOperations;

    public List<String> createBookIndexBulk(List<Book> books){
        List<IndexQuery> queries = books.stream()
                .map(book -> new IndexQueryBuilder()
                        .withId(book.getId())
                        .withObject(book).build())
                .collect(Collectors.toList());
        return elasticsearchOperations.bulkIndex(queries,
                IndexCoordinates.of(INDEX))
                .stream()
                .map(object -> object.getId())
                .collect(Collectors.toList());
    }

    public String createUserIndex(Book book) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(book.getId())
                .withObject(book).build();
        /*String documentId = elasticsearchOperations.index(indexQuery, IndexCoordinates.of(INDEX));
        return documentId;*/
        return elasticsearchOperations.index(indexQuery, IndexCoordinates.of(INDEX));
    }

    /*List<Product> products = fetchProducts();

BulkRequest.Builder br = new BulkRequest.Builder();

for (Product product : products) {
    br.operations(op -> op
        .index(idx -> idx
            .index("products")
            .id(product.getSku())
            .document(product)
        )
    );
}

BulkResponse result = esClient.bulk(br.build());

// Log errors, if any
if (result.errors()) {
    logger.error("Bulk had errors");
    for (BulkResponseItem item: result.items()) {
        if (item.error() != null) {
            logger.error(item.error().reason());
        }
    }
}*/
}
