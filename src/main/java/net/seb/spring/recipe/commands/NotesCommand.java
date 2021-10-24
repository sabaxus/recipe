package net.seb.spring.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.seb.spring.recipe.domain.Recipe;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    //private Recipe recipe;
    private String recipeNotes;
}
