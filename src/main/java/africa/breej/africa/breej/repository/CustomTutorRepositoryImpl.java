package africa.breej.africa.breej.repository;

import africa.breej.africa.breej.model.auth.Tutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
@Slf4j
public class CustomTutorRepositoryImpl implements CustomTutorRepository{
    private MongoTemplate mongoTemplate;

    public static final String PROJECT_BREEJ_DB_TUTOR = "project_breej_db_tutor";

    public CustomTutorRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<Tutor> findTutorByFilters(HashMap<String, Object> filters, LocalDateTime from, LocalDateTime to, Pageable pageable) {
        filters.put("deleted", false);
        Query query = new Query();
        for (String filter : filters.keySet()) {
            if (filters.get(filter) instanceof Collection)
                query.addCriteria(Criteria.where(filter).in((Collection<?>) filters.get(filter)));
            else
                query.addCriteria(Criteria.where(filter).is(filters.get(filter)));
        }

        //apply date filters
        if (from != null && to != null) {
            query.addCriteria(Criteria.where("timeCreated").lte(to).gte(from));
        } else if (from != null) {
            query.addCriteria(Criteria.where("timeCreated").gte(from));
        } else if (to != null) {
            query.addCriteria(Criteria.where("timeCreated").lte(to));
        }
        query.with(pageable);

        List<Tutor> tutorList = mongoTemplate.find(query, Tutor.class);
        return PageableExecutionUtils.getPage(tutorList, pageable,
                () -> mongoTemplate.count(query, Tutor.class));
    }
}
