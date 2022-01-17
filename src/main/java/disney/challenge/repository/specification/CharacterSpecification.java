
package disney.challenge.repository.specification;


import disney.challenge.dto.CharacterFilterDTO;
import disney.challenge.entities.CharacterEntity;
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
public class CharacterSpecification {
  public Specification<CharacterEntity> getByFilters(CharacterFilterDTO filterDTO){

        //Lambda function
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            //Creating a dynamic query, hasLength() checks if it exist.
            if(StringUtils.hasLength(filterDTO.getName())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + filterDTO.getName().toLowerCase() + "%"));
            }

            if(filterDTO.getAge() != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("age"), filterDTO.getAge()								)
                );
            }

            if(!CollectionUtils.isEmpty(filterDTO.getMovies())) {
                Join<CharacterEntity, MovieEntity> join = root.join("characterMovies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filterDTO.getMovies()));
            }




            //Remove duplicates
            query.distinct(true);

            //Order by filtering
            String orderByField = "name";
            query.orderBy(
                    filterDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField))
                            :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0])); // Return the generated predicate as a list
        };
    }
}
