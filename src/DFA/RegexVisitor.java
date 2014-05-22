// Generated from Regex.g4 by ANTLR 4.1
package DFA;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RegexParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RegexVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RegexParser#klammerung}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKlammerung(@NotNull RegexParser.KlammerungContext ctx);

	/**
	 * Visit a parse tree produced by {@link RegexParser#konkatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKonkatenation(@NotNull RegexParser.KonkatenationContext ctx);

	/**
	 * Visit a parse tree produced by {@link RegexParser#kleenestern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKleenestern(@NotNull RegexParser.KleenesternContext ctx);

	/**
	 * Visit a parse tree produced by {@link RegexParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(@NotNull RegexParser.StartContext ctx);

	/**
	 * Visit a parse tree produced by {@link RegexParser#alternation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlternation(@NotNull RegexParser.AlternationContext ctx);

	/**
	 * Visit a parse tree produced by {@link RegexParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull RegexParser.VariableContext ctx);
}