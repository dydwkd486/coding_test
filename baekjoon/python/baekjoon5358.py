while True:
    try:
        name = input()
        change_word_dict = {"e": "i", "i": "e", "E": "I", "I": "E"}
        new_name_list = [change_word_dict[word] if word in change_word_dict else word for word in list(name)]
        print("".join(new_name_list))
    except EOFError:
        break