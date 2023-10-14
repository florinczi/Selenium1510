from data.crawler import Crawler


with Crawler() as bot:
    bot.goto_login_page()
    bot.login("locked_out_user")
    bot.check_for_error_message()
    bot.login()
    bot.select_product("Sauce Labs Bolt T-Shirt")
    bot.add_to_cart()
    bot.goto_cart()
    bot.select_in_cart("Sauce Labs Bolt T-Shirt")
    bot.check_price("$15.99")
    bot.goto_checkout()
    bot.enter_name()
    bot.check_total_price("Total: $17.27")
    
    