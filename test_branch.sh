local_branch="$(git rev-parse --abbrev-ref HEAD)"

valid_branch_regex="^(ROB-)[0-9]"

if [[ ! $local_branch =~ $valid_branch_regex ]]
then
echo "Nazwa gałęzi jest niepoprawna ${local_branch}"
echo "Poprawna nazwa powinna mieć składnie ROB-[numer_zadania] , aby zmienić nazwę gałęzi użyj polecenia:"
echo "git branch -m [aktualna_nazwa_gałęzi] [poprawna_nazwa_gałęzi]"
exit 1
fi

exit 0