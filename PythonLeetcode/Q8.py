import math


def myAtoi( str: str):
    str=str.strip();
    if len(str) == 0:
        return 0
    res = 0
    if str[0] == '-':
        index = 1
        while index<len(str) and str[index].isdigit():
            if res > 214748365 or res >= 214748364 and int(str[index]) > 8:
                return int(-math.pow(2,31))
            res = res * 10 + int(str[index])
            index += 1
        return -res
    else:
        index = 1 if str[0] == '+' else 0
        while index<len(str) and  str[index].isdigit():
            if res > 214748365 or res >= 214748364 and int(str[index]) >7:
                return int(math.pow(2,31) - 1)
            res = res * 10 + int(str[index])
            index += 1
    return res


print(myAtoi("2147483648"))