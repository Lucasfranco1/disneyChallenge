
package disney.challenge.repository.specification;


import disney.challenge.dto.MovieFilterDTO;
import disney.challenge.entities.GenderEntity;
import disney.challenge.entities.MovieEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;


@Component
public class MovieSpecification {

public Specification<MovieEntity> getFiltered(MovieFilterDTO movieFilters){

        // Lambda:
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // for Title 
            if(StringUtils.hasLength(movieFilters.getTitle())) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + movieFilters.getTitle().toLowerCase() + "%"
                        )
                );
            }

            // for Gender
            if(!CollectionUtils.isEmpty(movieFilters.getGenders())) {
                Join<MovieEntity, GenderEntity> join = root.join("movieGenders", JoinType.INNER);
                Expression<String> gendersId = join.get("id");
                predicates.add(gendersId.in(movieFilters.getGenders()));
            }
            //Remove duplicates
            query.distinct(true);

            // for Order ASC o DES
            String orderByField = "title";
            query.orderBy(
                    movieFilters.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );


            // MAIN RETURN:
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
