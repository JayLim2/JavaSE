function pipe(cmd1, cmd2, cmd3) {
    $EXEC(cmd2, cmd1);
    return $EXEC(cmd3, cmd2);
}

var a = pipe('find .', 'grep -v class', 'sort');
print(a);