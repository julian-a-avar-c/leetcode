default:
  just --list

create-problem n:
  #!/usr/bin/env sh
  problem_dir="leetcode/src/julianaavarc/leetcode/problem"
  problem_test_dir="leetcode/test/src/julianaavarc/leetcode/problem"
  
  old_problem_dir="$problem_dir/template"
  old_problem="$old_problem_dir/Solution.scala"

  old_problem_test_dir="$problem_test_dir/template"
  old_problem_test="$old_problem_test_dir/ProblemTemplateSpec.scala"

  new_problem_dir="$problem_dir/{{n}}"
  new_problem="$new_problem_dir/Solution.scala"
  
  new_problem_test_dir="$problem_test_dir/{{n}}"
  new_problem_test="$new_problem_test_dir/Problem{{n}}Spec.scala"

  mkdir "$new_problem_dir"
  cp "$old_problem" "$new_problem"
  sed -i 's/\.template/.\`{{n}}\`/gI' "$new_problem"
  sed -i 's/template/{{n}}/gI' "$new_problem"

  mkdir "$new_problem_test_dir"
  cp "$old_problem_test" "$new_problem_test"
  sed -i 's/\.template/.\`{{n}}\`/gI' "$new_problem_test"
  sed -i 's/template/{{n}}/gI' "$new_problem_test"

# echo "2"
# cp -r "$old_problem_test_dir" "$new_problem_test_dir"
# echo "3"
# mv "$old_test_file" "$new_test_file"
# # Modify files
# echo "4"
# sed -i 's/template/\`{{n}}\`/gI' "$new_problem_dir/Solution.scala"
# echo "5"
# sed -i 's/template/{{n}}/gI' "$new_test_file"

delete-problem n:
  #!/usr/bin/env sh
  problem_dir="leetcode/src/julianaavarc/leetcode/problem"
  problem_test_dir="leetcode/test/src/julianaavarc/leetcode/problem"

  rm -rf "$problem_dir/{{n}}"
  rm -rf "$problem_test_dir/{{n}}"

# leetcode/test/src/julianaavarc/leetcode/problem/1/Problem1Spec.scala
# leetcode/test/src/julianaavarc/leetcode/problem/1/Problem1Spec.scala